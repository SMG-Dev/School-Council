package SMG.SchoolCouncilPanel.entities.transformers;

import SMG.SchoolCouncilPanel.entities.Course;
import SMG.SchoolCouncilPanel.entities.Details.CourseDetails;
import SMG.SchoolCouncilPanel.entities.Track;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;

import java.util.List;

public class CourseTrackUtils {
	public static CourseDetails getFullCourse (GenericRepository<Track> tracks, Course c) {
		CourseDetails answer = new CourseDetails (c);
		List <Track> track = tracks.getBy ("id", c.getTrackId ());
		if (track.size () == 0)
			answer.setTrack (new Track ());
		else
			answer.setTrack (track.get (0));
		return answer;
	}
}
