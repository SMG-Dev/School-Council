package SMG.SchoolCouncilPanel.entities.transformers;

import SMG.SchoolCouncilPanel.entities.Comment;
import SMG.SchoolCouncilPanel.entities.Course;
import SMG.SchoolCouncilPanel.entities.Details.CommentDetails;
import SMG.SchoolCouncilPanel.entities.Details.CourseDetails;
import SMG.SchoolCouncilPanel.entities.Track;
import SMG.SchoolCouncilPanel.entities.User;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;

import java.util.List;

public class CommentUserUtils {

	public static CommentDetails getPrintableComment (GenericRepository<User> users, Comment c) {
		CommentDetails answer = new CommentDetails (c);
		List<User> user = users.getBy ("id", c.getUserId ());
		if (user.size () == 0)
			answer.setUser (new User ());
		else
			answer.setUser (user.get (0));
		return answer;
	}
}