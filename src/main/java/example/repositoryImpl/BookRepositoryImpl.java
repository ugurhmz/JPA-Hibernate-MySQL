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
            System.out.println("Kitap kayıt başarılı...");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Kitap kayıt işlemi başarısız. Hata: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Book book) {
        try {
            transaction.begin();
            entityManager.remove(book);
            transaction.commit();
            System.out.println("Silme işlem başarıyla tamamlandı...");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Silme işlem başarısız oldu. Hata: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Book find(int id) {
        Book thatBook = entityManager.find(Book.class, id);

        if (thatBook != null) {
            return thatBook;
        }
        return null;
    }

    @Override
    public Book update(Book book) {
        try {
            transaction.begin();
            Book updatedBook = entityManager.merge(book);
            transaction.commit();
            System.out.println("Kitap güncelleme işlemi başarıyla tamamlandı. Güncellenen Kitap: " + updatedBook);
            return updatedBook;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Kitap güncelleme işlemi başarısız oldu. Hata: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
