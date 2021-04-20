package ada.wm2.libraryApp.repo;

import ada.wm2.libraryApp.entity.Book;
import ada.wm2.libraryApp.entity.User;
import ada.wm2.libraryApp.entity.UserBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserBooksRepository extends JpaRepository<UserBooks, Long> {
    List<UserBooks> findAllByUser(User user);

    Optional<UserBooks> findByBook(Book book);

    long removeUserBooksByBookAndUser(Book book, User user);
}
