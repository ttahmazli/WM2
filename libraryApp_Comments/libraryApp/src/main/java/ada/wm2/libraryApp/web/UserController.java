package ada.wm2.libraryApp.web;

import ada.wm2.libraryApp.entity.User;
import ada.wm2.libraryApp.entity.UserBooks;
import ada.wm2.libraryApp.model.GetById;
import ada.wm2.libraryApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    ResponseEntity<String> save(@RequestBody @Validated User user) {
        log.info(user.toString());
        return userService.save(user);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Validated @RequestBody GetById bookId) {
        log.info("bookId " + bookId);
        return userService.add(bookId);
    }

    @PostMapping("/drop")
    public ResponseEntity<String> drop(@Validated @RequestBody GetById bookId) {
        log.info("bookId " + bookId);
        return userService.drop(bookId);
    }

    @PostMapping("/books")
    public ResponseEntity<List<UserBooks>> myBooks() {
        log.info("user books called");
        return userService.myBooks();
    }
}
