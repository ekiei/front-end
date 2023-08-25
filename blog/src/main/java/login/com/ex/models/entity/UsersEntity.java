package login.com.ex.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UsersEntity {

	@Id
	@Column(name="users_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long usersId;
	
	@Column(name="users_name")
	private String usersName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;

	public UsersEntity() {

	}

	public UsersEntity(String usersName, String password, String email) {
		this.usersName = usersName;
		this.password = password;
		this.email = email;
	}

	public Long getUsersId() {
		return usersId;
	}

	public void setUsersId(Long usersId) {
		this.usersId = usersId;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
