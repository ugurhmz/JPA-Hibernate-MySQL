package example.repository;

import example.entity.Book;
import example.jpaFactory.JpaFactory;
import example.jpaFactoryImpl.JpaFactoryImpl;

public interface BookRepository {

   JpaFactory jpaFactory = new JpaFactoryImpl();

    void save(Book book);

    void delete(Book book);

    Book find(int id);

    Book update(Book book);
}
