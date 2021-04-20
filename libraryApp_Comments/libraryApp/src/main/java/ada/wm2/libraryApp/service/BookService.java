package ada.wm2.libraryApp.service;

import ada.wm2.libraryApp.entity.Book;
import ada.wm2.libraryApp.exception.GeneralException;
import ada.wm2.libraryApp.model.GetByCategory;
import ada.wm2.libraryApp.repo.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll() {
        log.info("book service get all");
        return bookRepository.findAll();
    }

    public ResponseEntity<Book> getById(Long id) {
        log.info("book service get by id");
        return new ResponseEntity<>(bookRepository.findById(id)
                .orElseThrow(() -> new GeneralException("book not found")), HttpStatus.OK);
    }

    public ResponseEntity<Book> add(Book book) {
        return new ResponseEntity<>(bookRepository.save(book), HttpStatus.OK);
    }

    public List<Book> getAllByCategory(GetByCategory byCategory) {
        log.info("book service get by category");
        return bookRepository.findAllByCategory(byCategory.getCategory());
    }

    public Book get(Book book) {
        log.info("book service get by category");
        return bookRepository.findByTitleOrAuthorOrCategory(book.getTitle(), book.getAuthor(), book.getCategory())
                .orElseThrow(() -> new GeneralException("book not found"));
    }
}
