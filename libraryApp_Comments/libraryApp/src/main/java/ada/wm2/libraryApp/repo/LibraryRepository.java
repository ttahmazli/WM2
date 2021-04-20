package ada.wm2.libraryApp.repo;


import ada.wm2.libraryApp.entity.Book;
import ada.wm2.libraryApp.entity.Library;
import ada.wm2.libraryApp.enumm.Accessible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    Library findByBook(Book book);

    Optional<Library> findByBookAndQuantityGreaterThanAndAccessible(Book book, Long quantity, Accessible accessible);

}
