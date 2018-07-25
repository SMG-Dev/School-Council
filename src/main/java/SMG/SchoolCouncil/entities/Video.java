package SMG.SchoolCouncilPanel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name = "videos")
public class Video implements Serializable, SMG.SchoolCouncilPanel.entities.base.Entity {

	private int id;
	private String name;
	private String sourceUrl;
	private String label;
	private int courseId;
	private String examLink;

	public Video () {
		this (-1, "", -1);
	}

	protected Video (int id, String name, int courseId) {
		setId (id);
		setName (name);
		setCourseId (courseId);
	}

	@Override
	@Id
	@Column(name = "id")
	public int getId () {
		return id;
	}

	@Override
	public void setId (int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName () {
		return name;
	}
	public void setName (String name) {
		this.name = name;
	}

	@Column(name = "courseId")
	public int getCourseId () { return this.courseId; }
	public void setCourseId (int courseId) { this.courseId = courseId; }

	@Column(name = "url")
	public String getSourceUrl () {
		return sourceUrl;
	}

	public void setSourceUrl (String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	@Column(name = "label")
	public String getLabel () {
		return label;
	}

	public void setLabel (String label) {
		this.label = label;
	}

	@Column(name = "examLink")
	public String getExamLink () {
		return examLink;
	}

	public void setExamLink (String examLink) {
		this.examLink = examLink;
	}
}
