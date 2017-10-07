package weekend.task4;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "select u from User u"),
		@NamedQuery(name = "User.findById", query = "select u from User u where u.id = :ID"),
		@NamedQuery(name = "User.getPary", query = "select new weekend.examples.Pary(u.login, u.password) from User u")})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String login;
	private String password;
	
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

}
