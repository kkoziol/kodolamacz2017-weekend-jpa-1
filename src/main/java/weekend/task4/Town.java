package weekend.task4;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "towns")
public class Town {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String name;
  private int inhabitantsCount;
  
  @OneToMany
  List<User> users;
  

  public Town(String name, int inhabitantsCount) {
    this.name = name;
    this.inhabitantsCount = inhabitantsCount;
  }

  public Town() {
  }

  
  
  public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getInhabitantsCount() {
	return inhabitantsCount;
}

public void setInhabitantsCount(int inhabitantsCount) {
	this.inhabitantsCount = inhabitantsCount;
}

public List<User> getUsers() {
	return users;
}

public void setUsers(List<User> users) {
	this.users = users;
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
