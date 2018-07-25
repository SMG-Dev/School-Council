package SMG.SchoolCouncilPanel.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "comments")
public class Comment implements Serializable, SMG.SchoolCouncilPanel.entities.base.Entity {

	private int id;
	private int userId;
	private int videoId;
	private String time;
	private String text;

	public Comment () {
		this(-1,-1,-1,"","");
	}

	public Comment (int userId, int videoId, String time, String text) {
		this(-1, userId, videoId, time, text);
	}

	protected Comment (int id, int userId, int videoId, String time, String text) {
		setId (id);
		setUserId (userId);
		setVideoId (videoId);
		setTime (time);
		setText (text);
	}

	@Override
	public void setId (int id) {
		this.id = id;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "user")
	public int getUserId () {
		return userId;
	}

	public void setUserId (int userId) {
		this.userId = userId;
	}

	@Column(name = "video")
	public int getVideoId () {
		return videoId;
	}

	public void setVideoId (int videoId) {
		this.videoId = videoId;
	}

	@Column(name = "time")
	public String getTime () {
		return time;
	}

	public void setTime (String time) {
		this.time = time;
	}

	@Column(name = "text")
	public String getText () {
		return text;
	}

	public void setText (String text) {
		this.text = text;
	}
}
