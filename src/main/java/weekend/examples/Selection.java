package weekend.examples;


import weekend.Notebook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Selection {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    Notebook notebook = entityManager.find(Notebook.class, 2);
    System.out.println(notebook);

    entityManager.close();
    entityManagerFactory.close();
  }
}
