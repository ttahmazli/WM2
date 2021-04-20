package ada.wm2.libraryApp.web;

import ada.wm2.libraryApp.entity.Book;
import ada.wm2.libraryApp.model.GetByCategory;
import ada.wm2.libraryApp.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/all")
    ResponseEntity<List<Book>> getAll() {
        log.info("get all called");
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Book> add(@RequestBody @Valid Book book) {
        return bookService.add(book);
    }

    @PostMapping("/category")
    public ResponseEntity<List<Book>> getByCategory(@RequestBody @Valid GetByCategory byCategory) {
        return new ResponseEntity<>(bookService.getAllByCategory(byCategory), HttpStatus.OK);
    }

    @PostMapping("/get")
    public ResponseEntity<Book> getBy(@RequestBody @Valid Book book) {
        return new ResponseEntity<>(bookService.get(book), HttpStatus.OK);
    }
}
