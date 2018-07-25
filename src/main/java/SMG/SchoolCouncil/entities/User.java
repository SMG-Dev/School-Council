package SMG.SchoolCouncilPanel.entities;

import SMG.SchoolCouncilPanel.entities.base.Secured;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "users")
public class User implements Secured, Serializable, SMG.SchoolCouncilPanel.entities.base.Entity {

	private int id;
	private String name, username, email;
	private String password;
	private String role;

	/* create guest user */
	public User () {
		this(-1,"Guest","","","","None");
	}

	private User (int id, String name, String username, String email, String password, String role) {
		setId (id);
		setName (name);
		setUsername (username);
		setEmail (email);
		setPassword (password);
		setRole (role);
	}

	@Override
	public void setId (int id) {
		this.id = id;
	}

	public void setName (String name) {
		this.name = name;
	}

	public void setUsername (String username) {
		this.username = username;
	}

	public void setEmail (String email) {
		this.email = email;
	}

	public void setPassword (String password) {
		this.password = password;
	}

	public void setRole (String role) {
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	@Column(name = "role")
	public String getRole() {
		return role;
	}
}
