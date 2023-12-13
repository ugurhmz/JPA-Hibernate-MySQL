package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Create & Connect DB
        createDB();

        // Create EntityManager
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        // CREATE PRODUCT
        createProduct(entityManager, transaction);


    }

    public static void createProduct(EntityManager entityManager, EntityTransaction transaction) {
        Product prd1 = new Product(0, "Iphone 6", 2500.99, 44, new Date(), null);
        Product prd2 = new Product(0, "Iphone 7", 1500.99, 33, new Date(), null);
        Product prd3 = new Product(0, "Iphone 8", 3500.99, 156, new Date(), null);
        transaction.begin();
        entityManager.persist(prd1);
        entityManager.persist(prd2);
        entityManager.persist(prd3);
        transaction.commit();
    }

    public static void createDB() {

        // Veritabanı bağlantısı için gerekli bilgiler
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "1994ugur";

        // JDBC sürücüsünü yükle
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Veritabanı bağlantısı oluştur
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // SQL komutu ile veritabanını oluştur
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS jpa_db";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createDatabaseSQL);
                System.out.println("Veritabanı oluşturuldu: jpa_db");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}