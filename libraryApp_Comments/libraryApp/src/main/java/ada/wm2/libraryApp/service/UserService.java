package ada.wm2.libraryApp.service;

import ada.wm2.libraryApp.entity.Book;
import ada.wm2.libraryApp.entity.Library;
import ada.wm2.libraryApp.entity.User;
import ada.wm2.libraryApp.entity.UserBooks;
import ada.wm2.libraryApp.enumm.Accessible;
import ada.wm2.libraryApp.exception.GeneralException;
import ada.wm2.libraryApp.model.GetById;
import ada.wm2.libraryApp.repo.BookRepository;
import ada.wm2.libraryApp.repo.LibraryRepository;
import ada.wm2.libraryApp.repo.RoleRepository;
import ada.wm2.libraryApp.repo.UserBooksRepository;
import ada.wm2.libraryApp.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserBooksRepository userBooksRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    public ResponseEntity<String> save(User user) {
        JSONObject jsonObject = new JSONObject();
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new GeneralException("User already exist");
        } else {
            user.setRole(roleRepository.findById(1L).get());
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userRepository.save(user);
        }
        jsonObject.put("message", "user added");
        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }

    public ResponseEntity<String> add(GetById getById) {
        User user = getCurrentUser();

        JSONObject jsonObject = new JSONObject();

        Book book = bookRepository.findById(getById.getId())
                .orElseThrow(() -> new GeneralException("book not found"));

        log.info(book.toString());

        Optional<Library> bookFromShelf = libraryRepository
                .findByBookAndQuantityGreaterThanAndAccessible(book, 0L, Accessible.YES);

        bookFromShelf.ifPresent(library -> {

            library.setQuantity(library.getQuantity() - 1);

            UserBooks userBook = new UserBooks(user, book);

            userBooksRepository.save(userBook);

            if (library.getQuantity().equals(0L)) library.setAccessible(Accessible.NO);

            libraryRepository.save(library);
        });

        jsonObject.put("message", "book added");
        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }

    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = ((UserDetails) principal).getUsername();
        log.info("current logged user " + username);
        User user = userRepository.findByEmail(username);
        return user;

    }

    public ResponseEntity<List<UserBooks>> myBooks() {
        User user = getCurrentUser();
        return new ResponseEntity<>(userBooksRepository.findAllByUser(user), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<String> drop(GetById bookId) {
        User user = getCurrentUser();
        Book book = bookRepository.findById(bookId.getId())
                .orElseThrow(() -> new GeneralException("book not found"));
        UserBooks myBooks = userBooksRepository.findByBook(book)
                .orElseThrow(() -> new GeneralException("you do not have book with the given Id"));
        userBooksRepository.removeUserBooksByBookAndUser(book, user);
        Library library = libraryRepository.findByBook(book);
        library.setQuantity(library.getQuantity() + 1L);
        if (library.getAccessible().equals(Accessible.NO)) library.setAccessible(Accessible.YES);
        libraryRepository.save(library);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "book dropped");
        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }
}
