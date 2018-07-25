package SMG.SchoolCouncilPanel.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "courses")
public class Course implements Serializable, SMG.SchoolCouncilPanel.entities.base.Entity {

	private int id;
	private String name;
	private int trackId;

	public Course () {
		this (-1, "", -1);
	}

	protected Course (int id, String name, int trackId) {
		setId (id);
		setName (name);
		setTrackId (trackId);
	}

	@Override
	public void setId (int id) {
		this.id = id;
	}
	public void setName (String name) {
		this.name = name;
	}
	public void setTrackId (int trackId) {
		this.trackId = trackId;
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

	@Column(name = "trackId")
	public int getTrackId() {
		return trackId;
	}
}
