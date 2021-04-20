package ada.wm2.libraryApp.entity;

import ada.wm2.libraryApp.enumm.Accessible;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity

public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shelfId;

    @OneToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    private Long quantity;

    @Enumerated(EnumType.STRING)
    private Accessible accessible;

    public Library() {
    }

    public Library(Book book, Long quantity) {
        this.book = book;
        this.quantity = quantity;
        this.accessible = Accessible.YES;
    }

    @Override
    public String toString() {
        return "Library{" +
                "book=" + book +
                ", quantity=" + quantity +
                ", accessible=" + accessible +
                '}';
    }
}
