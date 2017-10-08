package weekend.examples;


import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import weekend.task4.User;

public class UserWithDate {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
	TypedQuery<User> query = entityManager.createNamedQuery("User.findById", User.class);
	query.setParameter("ID", 2);
    User result = query.getSingleResult();
	System.out.println("z bazy: "+result);
	
	Calendar c = Calendar.getInstance();
	c.set(2017, 9, 05, 13, 06);
    Date date = c.getTime();
    
	result.setRegistrationDate(date);
	
	System.out.println("do bazy: "+result);
	transaction.commit();
    entityManager.close();
    entityManagerFactory.close();
  }
}
