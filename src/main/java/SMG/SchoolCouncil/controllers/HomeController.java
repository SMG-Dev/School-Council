package SMG.SchoolCouncilPanel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import SMG.SchoolCouncilPanel.entities.Course;
import SMG.SchoolCouncilPanel.entities.Track;
import SMG.SchoolCouncilPanel.entities.transformers.CourseTrackUtils;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;

import java.util.stream.Collectors;


@Controller
public class HomeController {

	@Autowired
	GenericRepository<Track> trackRepo;

	@Autowired
	GenericRepository<Course> courseRepo;

	@GetMapping(value={"","/","/home"})
	public String home (Model model) {
		model = SMG.SchoolCouncilPanel.controllers.BaseController.setGuest (model);
		model.addAttribute ("tracks", trackRepo.getAll ().subList (0, 3));
		model.addAttribute ("courses",
				courseRepo.getAll ().subList (0, 3)
						.stream ()
						.map (x -> CourseTrackUtils.getFullCourse (trackRepo, x))
						.collect (Collectors.toList ()));

		return "home";
	}

	@GetMapping(value={"companies"})
	public String companies (Model model) {
		model = SMG.SchoolCouncilPanel.controllers.BaseController.setGuest (model);

		return "companies";
	}

}