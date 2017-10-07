package weekend.task4;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

public class UserDao {
  private final EntityManager entityManager;

  public UserDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List<User> getAll() {
	TypedQuery<User> createNamedQuery = entityManager.createNamedQuery("User.getAll",User.class);
	TypedQuery<User> createQuery = entityManager.createQuery("select u from UserS were u.id=:ppp", User.class);
    return createNamedQuery.getResultList();
  }
  
  public List<User> getUsersFromTown(String town) {
    //noinspection unchecked
    return entityManager.createNativeQuery(
        "select * from usersS u join towns t on u.town_id = t.id where t.name = :town",
        User.class
    )
        .setParameter("town", town)
        .getResultList();
  }
}
