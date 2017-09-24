package weekend.task4;

import javax.persistence.*;

@Entity
@Table(name = "towns")
public class Town {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String name;
  private int inhabitantsCount;

  public Town(String name, int inhabitantsCount) {
    this.name = name;
    this.inhabitantsCount = inhabitantsCount;
  }

  public Town() {
  }

  @Override
  public String toString() {
    return "Town{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", inhabitantsCount=" + inhabitantsCount +
        '}';
  }
}
