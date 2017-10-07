package weekend;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "notebooks")
public class Notebook {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String model;
  private int resolution;

  public Notebook(String model, int resolution) {
    this.model = model;
    this.resolution = resolution;
  }

  public Notebook() {
  }

  @Override
  public String toString() {
    return "Notebook{" +
        "model='" + model + '\'' +
        ", resolution=" + resolution +
        '}';
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setResolution(int resolution) {
    this.resolution = resolution;
  }
}
