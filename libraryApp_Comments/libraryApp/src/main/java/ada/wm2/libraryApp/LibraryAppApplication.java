package ada.wm2.libraryApp;

import ada.wm2.libraryApp.entity.Book;
import ada.wm2.libraryApp.entity.Library;
import ada.wm2.libraryApp.entity.Role;
import ada.wm2.libraryApp.entity.User;
import ada.wm2.libraryApp.repo.BookRepository;
import ada.wm2.libraryApp.repo.LibraryRepository;
import ada.wm2.libraryApp.repo.RoleRepository;
import ada.wm2.libraryApp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LibraryAppApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryRepository libraryRepository;

    public static void main(String[] args) {
        SpringApplication.run(LibraryAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role();
        role.setName("user");
        Role role1 = new Role();
        role1.setName("admin");
        roleRepository.save(role);
        roleRepository.save(role1);
        User user = new User();
        user.setEmail("example@mail.ru");
        user.setFistName("togrul");
        user.setPassword(new BCryptPasswordEncoder().encode("123"));
        user.setRole(roleRepository.findById(1L).get());
        userRepository.save(user);
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Grass is Always Greener", "Jeffrey Archer", 10L, "Modern Times"));
        books.add(new Book("Murder!", "Arnold Bennett", 15L, "Crime"));
        books.add(new Book("An Occurrence at Owl Creek Bridge One of the Missing", "Ambrose Bierce", 10L, "Adventure"));
        books.add(new Book("A Boy at Seven", "John Bidwell", 20L, "Modern Times"));
        books.add(new Book("The Higgler", "A. E. Coppard", 22L, "Romance"));
        books.add(new Book("The Open Boat", "Stephen Crane", 26L, "Classic"));
        books.add(new Book("The Great Switcheroo", "Roald Dahl", 17L, "N/A"));
        books.add(new Book("The Speckled Band", "Sir Arthur Conan Doyle", 18L, "Crime"));
        books.add(new Book("The Signalman", "Charles Dickens", 30L, "Suspense"));
        books.add(new Book("The Five Orange Pips", "Arthur Conan Doyle", 9L, "Crime"));
        books.add(new Book("The Diamond as Big as the Ritz", "F. Scott Fitzgerald", 11L, "Science Fiction"));
        books.add(new Book("From a View to a Kill", "Ian Fleming", 15L, "Adventure"));
        books.add(new Book("The Hostage", "C. S. Forester", 25L, "Adventure"));
        books.add(new Book("A Chance for Mr Lever", "Graham Greene", 35L, "Classic"));
        books.add(new Book("A Mere Interlude", "Thomas Hardy", 70L, "Romance"));
        bookRepository.saveAll(books);

        List<Library> bookList = new ArrayList<>();
        bookList.add(new Library(bookRepository.getOne(16L), 10L));
        bookList.add(new Library(bookRepository.getOne(17L), 5L));
        bookList.add(new Library(bookRepository.getOne(18L), 3L));
        bookList.add(new Library(bookRepository.getOne(4L), 7L));
        bookList.add(new Library(bookRepository.getOne(5L), 11L));
        bookList.add(new Library(bookRepository.getOne(6L), 9L));
        bookList.add(new Library(bookRepository.getOne(7L), 10L));
        bookList.add(new Library(bookRepository.getOne(8L), 6L));
        bookList.add(new Library(bookRepository.getOne(9L), 9L));
        bookList.add(new Library(bookRepository.getOne(10L), 3L));
        bookList.add(new Library(bookRepository.getOne(11L), 1L));
        bookList.add(new Library(bookRepository.getOne(12L), 2L));
        bookList.add(new Library(bookRepository.getOne(13L), 4L));
        bookList.add(new Library(bookRepository.getOne(14L), 2L));
        bookList.add(new Library(bookRepository.getOne(15L), 7L));
        libraryRepository.saveAll(bookList);
    }
}
