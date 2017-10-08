package weekend.task4;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class VIPUser {

	@Valid
	private User user;
    
	@NotNull
	private String rabat;
	

	public String getRabat() {
		return rabat;
	}

	public void setRabat(String rabat) {
		this.rabat = rabat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	


}
