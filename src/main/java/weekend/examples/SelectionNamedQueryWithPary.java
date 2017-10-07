package weekend.examples;


import weekend.Notebook;
import weekend.task4.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class SelectionNamedQueryWithPary {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    TypedQuery<Pary> query = entityManager.createNamedQuery("User.getPary", Pary.class);
    List<Pary> resultList = query.getResultList();
	System.out.println(resultList);

    entityManager.close();
    entityManagerFactory.close();
  }
}
