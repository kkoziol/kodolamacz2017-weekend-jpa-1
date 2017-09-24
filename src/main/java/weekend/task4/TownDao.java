package weekend.task4;

import javax.persistence.EntityManager;
import java.util.List;

public class TownDao {
  private final EntityManager entityManager;

  public TownDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List<Town> getTownsWithInhabitantsCountBetween(int from, int to) {
    //noinspection unchecked
    return entityManager.createNativeQuery(
        "select * from towns where inhabitants_count >= :from and inhabitants_count < :to",
        Town.class
    )
        .setParameter("from", from)
        .setParameter("to", to)
        .getResultList();
  }
}
