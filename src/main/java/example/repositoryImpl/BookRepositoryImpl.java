package example.repositoryImpl;

import example.entity.Book;
import example.repository.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class BookRepositoryImpl implements BookRepository {

    EntityManager entityManager = jpaFactory.getEntityManager();
    EntityTransaction transaction = jpaFactory.getEntityTransaction();

    @Override
    public void save(Book book) {
        try {
            transaction.begin();
            entityManager.persist(book);
            transaction.commit();
            System.out.println("Kayıt başarılı...");
        } catch (Exception e) {
            System.out.println("işlem başarısız " + e.getMessage());
        }
    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public Book find(int id) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }
}
