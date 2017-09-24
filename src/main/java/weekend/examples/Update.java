package weekend.examples;


import weekend.Notebook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Update {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();

    Notebook notebook = entityManager.find(Notebook.class, 2);
    notebook.setResolution(1400);

    entityManager.getTransaction().commit();
    entityManager.close();
    entityManagerFactory.close();
  }
}
