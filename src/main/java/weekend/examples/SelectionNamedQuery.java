package weekend.examples;


import weekend.Notebook;
import weekend.task4.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class SelectionNamedQuery {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    TypedQuery<User> query = entityManager.createNamedQuery("User.findAll", User.class);
    List<User> resultList = query.getResultList();
	System.out.println(resultList);

	
	query = entityManager.createNamedQuery("User.findById", User.class);
	query.setParameter("ID", 2);
    User result = query.getSingleResult();
	System.out.println(result);
	
    entityManager.close();
    entityManagerFactory.close();
  }
}
