package weekend.examples;


import weekend.Notebook;
import weekend.task4.User;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class UserWithDate {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
	TypedQuery<User> query = entityManager.createNamedQuery("User.findById", User.class);
	query.setParameter("ID", 2);
    User result = query.getSingleResult();
	System.out.println(result);
	
	Calendar c = Calendar.getInstance();
	c.set(2017, 9, 05, 13, 06);
    Date date = c.getTime();
	result.setRegistrationDate(date);
	
	LocalDate d = LocalDate.of(2017, 10, 03);
	Date.from(d.atStartOfDay().toInstant(ZoneOffset.UTC));
	System.out.println(d);
	
	LocalDate d2 = LocalDate.now();
	
	System.out.println(Period.between(d, d2));
	
	
	transaction.commit();
    entityManager.close();
    entityManagerFactory.close();
  }
}
