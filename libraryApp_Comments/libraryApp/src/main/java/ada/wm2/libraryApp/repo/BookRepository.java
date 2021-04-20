package ada.wm2.libraryApp.repo;


import ada.wm2.libraryApp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByCategory(String category);

    Optional<Book> findByTitleOrAuthorOrCategory(String name, String author, String category);

}
