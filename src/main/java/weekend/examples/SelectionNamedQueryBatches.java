package weekend.examples;

import weekend.Notebook;
import weekend.task4.User;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class SelectionNamedQueryBatches {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();

		tx.begin();

		TypedQuery<User> query = entityManager.createNamedQuery("User.findAll", User.class);
		List<User> resultList = query.getResultList();

		int i = 0;
		for (User user : resultList) {
            i++;
//			entityManager.detach(user);
			
			user.setRegistrationDate(null);
			
			 if ((i > 0) && (i % 2 == 0)) { // Flush in batches of 20 to keep
			   entityManager.flush();
			   entityManager.clear();
			 }
			 System.out.println("iteracja "+i);
			 user = entityManager.merge(user);
		}
        System.out.println("przed komitem");
		tx.commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}
