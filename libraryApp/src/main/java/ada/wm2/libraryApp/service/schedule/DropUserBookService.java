package ada.wm2.libraryApp.service.schedule;

import ada.wm2.libraryApp.entity.Library;
import ada.wm2.libraryApp.entity.UserBooks;
import ada.wm2.libraryApp.repo.LibraryRepository;
import ada.wm2.libraryApp.repo.UserBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DropUserBookService {

    @Autowired
    UserBooksRepository userBooksRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @Scheduled(cron = "0 0/1 * * * *")
    public void DropWhenEndDateReached() {

        List<UserBooks> userBooks = userBooksRepository.findAll();
        userBooks.forEach(book -> {
            boolean isBefore = book.getLastDate().isBefore(LocalDateTime.now());
            if (isBefore) {
                userBooksRepository.delete(book);
                Library byBook = libraryRepository.findByBook(book.getBook());
                byBook.setQuantity(byBook.getQuantity() + 1);
                libraryRepository.save(byBook);
            }
        });
    }
}
