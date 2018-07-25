package SMG.SchoolCouncilPanel.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "tracks")
public class Track implements Serializable, SMG.SchoolCouncilPanel.entities.base.Entity {

	private int id;
	private String name;
	private String planURL;

	public Track () {
		this (-1, "", "");
	}
	private Track (int id, String name, String planURL) {
		setId (id);
		setName (name);
		setPlanURL (planURL);
	}

	@Override
	public void setId (int id) {
		this.id = id;
	}

	public void setName (String name) {
		this.name = name;
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

	@Column(name = "url")
	public String getPlanURL () {
		return planURL;
	}

	public void setPlanURL (String planURL) {
		this.planURL = planURL;
	}
}
