package SMG.SchoolCouncilPanel.controllers.REST_API.Resources.Tracks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import SMG.SchoolCouncilPanel.controllers.ModelObjects.ExitState;
import SMG.SchoolCouncilPanel.controllers.ModelObjects.ExitStateData;
import SMG.SchoolCouncilPanel.controllers.REST_API.Resources.Authentication;
import SMG.SchoolCouncilPanel.entities.Course;
import SMG.SchoolCouncilPanel.entities.Track;
import SMG.SchoolCouncilPanel.entities.User;
import SMG.SchoolCouncilPanel.entities.Video;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/resources/tracks")
class TracksAdd
{
	@Autowired
	private GenericRepository<Track> tracks;

	@Autowired
	private GenericRepository <Course> courses;

	@Autowired
	private GenericRepository <Video> videos;

	@PostMapping (value = "/add", produces = "application/json")
	public ResponseEntity addTracks (HttpSession session
			, @RequestParam ("name") String name
			, @RequestParam("plan") String url
	)
	{
		if (!Authentication.isAdmin (session))
			return new ResponseEntity ("Permission denied", HttpStatus.UNAUTHORIZED);

		Track newTrack = new Track ();
		newTrack.setName (name);
		newTrack.setPlanURL (url);
		try {
			newTrack = tracks.create (newTrack);
		}
		catch (Exception ex) {
			return new ResponseEntity ("Cannot add this track: " + ex.getMessage (), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity (newTrack, HttpStatus.CREATED);
	}
}