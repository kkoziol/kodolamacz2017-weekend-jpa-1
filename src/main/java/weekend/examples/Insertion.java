package weekend.examples;


import weekend.Notebook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insertion {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();

    Notebook notebook = new Notebook("asus", 1600);
    entityManager.persist(notebook);

    entityManager.getTransaction().commit();
    entityManager.close();
    entityManagerFactory.close();
  }
}
