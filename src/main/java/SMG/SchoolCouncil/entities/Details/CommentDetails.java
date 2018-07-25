package SMG.SchoolCouncilPanel.entities.Details;

import SMG.SchoolCouncilPanel.entities.Comment;
import SMG.SchoolCouncilPanel.entities.Course;
import SMG.SchoolCouncilPanel.entities.Track;
import SMG.SchoolCouncilPanel.entities.User;

public class CommentDetails extends Comment {
	private User user;

	public CommentDetails (Comment c)
	{
		super (c.getId (), c.getUserId (), c.getVideoId (), c.getTime (), c.getText ());
	}

	public User getUser () { return this.user; }
	public void setUser (User user) { this.user = user; }
}
