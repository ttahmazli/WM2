package ada.wm2.libraryApp.entity;

import ada.wm2.libraryApp.model.CommentModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @Column(unique = true)
    private String title;

    private String author;

    private Long price;

    private String category;

    private List<CommentModel> comments;

    @JsonIgnore
    @OneToOne(mappedBy = "book")
    private Library library;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private List<UserBooks> bookUser;

    public Book(String title, String author, Long price, String category) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

}
