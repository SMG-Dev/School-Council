package SMG.SchoolCouncilPanel.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "activities")
public class Activity implements Serializable, SMG.SchoolCouncilPanel.entities.base.Entity {

	private int id;
	private int organizerId;
	private int alternateId;
	private String description;
	private String name;
	private String dateTime;
	private boolean archive;

	public Activity () {
		this(-1, -1, -1, "Untitled","","Never", false);
	}

	protected Activity (int id, int organizerId, int alternateId, String name, String description, String dateTime, boolean archive) {
		setId (id);
		setOrganizerId (organizerId);
		setAlternateId (alternateId);
		setName (name);
		setDescription (description);
		setDateTime (dateTime);
		setArchive (archive);
	}

	@Override
	public void setId (int id) {
		this.id = id;
	}

	public void setOrganizerId (int organizerId) {
		this.organizerId = organizerId;
	}

	public void setAlternateId (int alternateId) {
		this.alternateId = alternateId;
	}

	public void setName (String name) {
		this.name = name;
	}

	public void setDescription (String description) {
		this.description = description;
	}

	public void setDateTime (String dateTime) {
		this.dateTime = dateTime;
	}

	public void setArchive (boolean archive) {
		this.archive = archive;
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

	@Column(name = "organizer")
	public int getOrganizerId () {
		return organizerId;
	}

	@Column(name = "alternate")
	public int getAlternateId () {
		return alternateId;
	}

	@Column(name = "description")
	public String getDescription () {
		return description;
	}

	@Column(name = "datetime")
	public String getDateTime () {
		return dateTime;
	}

	@Column(name = "archive")
	public boolean getArchive () {
		return archive;
	}
}
