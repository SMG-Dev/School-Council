package SMG.SchoolCouncilPanel.entities;

import SMG.SchoolCouncilPanel.entities.base.Secured;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "users")
public class User implements Secured, Serializable, SMG.SchoolCouncilPanel.entities.base.Entity {

	private int id;
	private String name, telephone, custom;
	private String password;
	private String role;

	/* create guest user */
	public User () {
		this(-1,"Guest","","","","None");
	}

	private User (int id, String name, String telephone, String custom, String password, String role) {
		setId (id);
		setName (name);
		setCustom (custom);
		setTelephone (telephone);
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

	public void setTelephone (String telephone) {
		this.telephone = telephone;
	}

	public void setCustom (String custom) {
		this.custom = custom;
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

	@Column(name = "telephone")
	public String getTelephone() {
		return telephone;
	}

	@Column(name = "custom")
	public String getCustom() {
		return custom;
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
