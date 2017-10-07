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

public class SelectionNamedQueryBatchesInserts {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		long start = System.nanoTime();
		tx.begin();

		for (int j = 0; j < 100000; j++) {

			User u = new User("kk", "aa", null);
			u.setRegistrationDate(null);
			entityManager.persist(u);

			if ((j > 0) && (j % 20 == 0)) { // Flush in batches of 20 to keep
				entityManager.flush();
				entityManager.clear();
			}
			System.out.println("iteracja " + j);
			// user = entityManager.merge(user);
		}
		System.out.println("przed komitem");
		tx.commit();

		entityManager.close();
		entityManagerFactory.close();
		long koniec = System.nanoTime();
		System.out.println("--->" + (koniec - start));
	}
}
