package example;

import example.entity.Book;
import example.repository.BookRepository;
import example.repositoryImpl.BookRepositoryImpl;

import java.util.Calendar;
import java.util.Date;

public class MainTwo {
    public static void main(String[] args) {

    BookRepository bookRepository = new BookRepositoryImpl();

    Book book1 = new Book(0,"Yüzüklerin Efendisi", 4500,
            "lorem ipsum","J. R. R. Tolkien", dateFormatter(6,1,2017));
    Book book2 = new Book(0,"Harry Potter", 2500,
                "lorem ipsum","J. K. Rowling", dateFormatter(26,04,1994));

    bookRepository.save(book1);
    bookRepository.save(book2);

    }

    public static Date dateFormatter(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);

        return calendar.getTime();
    }

}
