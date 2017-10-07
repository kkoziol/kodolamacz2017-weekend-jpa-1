package weekend.examples;


import weekend.Notebook;
import weekend.Notebook_;
import weekend.task4.User;
import weekend.task4.User_;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class SelectionCriteria {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    CriteriaBuilder cb =  entityManager.getCriteriaBuilder();
    
    CriteriaQuery<Notebook> query = cb.createQuery(Notebook.class);

    Root<Notebook> from = query.from(Notebook.class);
    
    query.where(cb.equal(from.get(Notebook_.id), 15));
    
    List<Notebook> resultList = entityManager.createQuery(query).getResultList();
    
    System.out.println(resultList);
    
    cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<User> query2 = cb.createQuery(User.class);
    Root<User> from2 = query2.from(User.class);
    query2.where(cb.and(
    		cb.equal(from2.get(User_.login), "kk"),
    		cb.lessThan(from2.get(User_.id), 5))
    		);    
    List<User> resultList2 = entityManager.createQuery(query2).getResultList();
    System.out.println(resultList2);
    
    entityManager.close();
    entityManagerFactory.close();
  }
}
