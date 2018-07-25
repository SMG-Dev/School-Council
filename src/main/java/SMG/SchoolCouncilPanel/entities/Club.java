package SMG.SchoolCouncilPanel.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "clubs")
public class Club implements Serializable, SMG.SchoolCouncilPanel.entities.base.Entity {

	private int id;
	private int organizerId;
	private int alternateId;
	private String description;
	private String name;
	private String dateTime;

	/* create guest user */
	public Club () {
		this(-1, -1, -1, "Untitled","","Never");
	}

	private Club (int id, int organizerId, int alternateId, String name, String description, String dateTime) {
		setId (id);
		setOrganizerId (organizerId);
		setAlternateId (alternateId);
		setName (name);
		setDescription (description);
		setDateTime (dateTime);
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

}
