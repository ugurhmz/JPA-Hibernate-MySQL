package example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(name="book_name")
    @NonNull
    private String bookName;

    @Column(name="book_page_count")
    private int pageCount;

    @Column(name="book_topic")
    private String topic;

    @Column(name="book_author_name", length = 100)
    @NonNull
    private String authorName;

    @Column(name="book_publishing_date")
    @Temporal(TemporalType.DATE)
    private Date publishingDate;

}
