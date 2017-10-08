package weekend.task4;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "select u from User u"),
		@NamedQuery(name = "User.findById", query = "select u from User u where u.id = :ID"),
		@NamedQuery(name = "User.getPary", query = "select new weekend.examples.Pary(u.login, u.password) from User u")})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
	@NotNull
	private String login;

	//minimum 4 
	//(message zeby byly po polsku)
	@Size(min=4, message="Hasło powinno mieć minimum 4 znaki!")
	private String password;
	
	
	//napisac test sprawdzajacy działanie walidacji.
	//uzyc junit i assertJ
	
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;

	@ManyToOne
	private Town town;

	public User(String login, String password, Town town) {
		this.login = login;
		this.password = password;
		this.town = town;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", login='" + login + '\'' + ", password='" + password + '\'' + ", town=" + town
				+ '}';
	}

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public Town getTown() {
		return town;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTown(Town town) {
		this.town = town;
	}

}
