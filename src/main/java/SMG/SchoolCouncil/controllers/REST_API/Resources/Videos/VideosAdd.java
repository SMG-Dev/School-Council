package SMG.SchoolCouncilPanel.controllers.REST_API.Resources.Videos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import SMG.SchoolCouncilPanel.controllers.ModelObjects.ExitState;
import SMG.SchoolCouncilPanel.controllers.REST_API.Resources.Authentication;
import SMG.SchoolCouncilPanel.entities.Course;
import SMG.SchoolCouncilPanel.entities.Track;
import SMG.SchoolCouncilPanel.entities.Video;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/resources/videos")
public class VideosAdd {
	@Autowired
	private GenericRepository<Track> tracks;

	@Autowired
	private GenericRepository <Course> courses;

	@Autowired
	private GenericRepository <Video> videos;

	@PostMapping (value = "/add", produces = "application/json")
	public ResponseEntity addVideo (HttpSession session
			, @RequestParam ("name") String name
			, @RequestParam ("source") String sourceUrl
			, @RequestParam ("label") String label
			, @RequestParam ("courseId") int courseId
	) {
		if (!Authentication.isAdmin (session))
			return new ResponseEntity ("Permission denied", HttpStatus.UNAUTHORIZED);
		if (courses.getBy ("id", courseId).size () == 0)
			return new ResponseEntity ("Invalid course id", HttpStatus.NO_CONTENT);
		Video unit = new Video ();
		unit.setName (name);
		unit.setCourseId (courseId);
		unit.setLabel (label);
		unit.setSourceUrl (sourceUrl);
		final Video newVideo;
		try {
			newVideo = videos.create (unit);
		}
		catch (Exception ex) {
			return new ResponseEntity ("Cannot add this video: " + ex.getMessage (), HttpStatus.SERVICE_UNAVAILABLE);
		}

		return new ResponseEntity (newVideo, HttpStatus.CREATED);
	}
}
