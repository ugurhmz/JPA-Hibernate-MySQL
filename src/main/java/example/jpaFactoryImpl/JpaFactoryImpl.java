package example.jpaFactoryImpl;

import example.jpaFactory.JpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaFactoryImpl implements JpaFactory {

    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
        this.entityManager = factory.createEntityManager();
        return entityManager;
    }

    @Override
    public EntityTransaction getEntityTransaction() {
        EntityTransaction transaction = this.entityManager.getTransaction();
        return transaction;
    }
}
