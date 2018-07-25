package SMG.SchoolCouncilPanel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import SMG.SchoolCouncilPanel.entities.Course;
import SMG.SchoolCouncilPanel.entities.Track;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;

import java.util.List;

@RequestMapping("/trainings")
@Controller
public class TrainingController {

	@Autowired
	GenericRepository<Track> trackRepo;

	@Autowired
	GenericRepository<Course> courseRepo;

	@GetMapping (value = {"/tracks"})
	public String showTracks (Model model)
	{
		model = SMG.SchoolCouncilPanel.controllers.BaseController.setGuest (model);
		List<Track> currentTrack = trackRepo.getAll ();
		model = SMG.SchoolCouncilPanel.controllers.BaseController.setGuest (model);

		if (currentTrack.size () == 0) {
			//model.addAttribute ("url", "/track/" + String.valueOf (id));
			return "404";
		}

		model.addAttribute ("name", "Tracks");
		model.addAttribute ("prefix", "/course");
		model.addAttribute ("courses", currentTrack);

		return "training";
	}

	@GetMapping (value = {"/courses"})
	public String showCourses (Model model)
	{
		model = SMG.SchoolCouncilPanel.controllers.BaseController.setGuest (model);
		List<Course> currentTrack = courseRepo.getAll ();
		model = SMG.SchoolCouncilPanel.controllers.BaseController.setGuest (model);

		if (currentTrack.size () == 0) {
			//model.addAttribute ("url", "/track/" + String.valueOf (id));
			return "404";
		}

		model.addAttribute ("name", "Courses");
		model.addAttribute ("prefix", "/track");
		model.addAttribute ("courses", currentTrack);

		return "training";
	}
}
