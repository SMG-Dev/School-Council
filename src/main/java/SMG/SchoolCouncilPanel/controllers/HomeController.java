package SMG.SchoolCouncilPanel.controllers;

import SMG.SchoolCouncilPanel.entities.Activity;
import SMG.SchoolCouncilPanel.entities.Club;
import SMG.SchoolCouncilPanel.entities.User;
import SMG.SchoolCouncilPanel.transforms.ActivityDetailsUntil;
import SMG.SchoolCouncilPanel.transforms.ClubDetailsUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;

import java.awt.*;
import java.util.stream.Collectors;


@Controller
public class HomeController {

	@Autowired
	GenericRepository<Activity> activityRepo;

	@Autowired
	GenericRepository<Club> clubRepo;

	@Autowired
	GenericRepository<User> userRepo;

	@GetMapping(value={"","/","/home"})
	public String home (Model model) {
		model = SMG.SchoolCouncilPanel.controllers.BaseController.setGuest (model);

		return "home";
	}

	@GetMapping(value={"/clubs"})
	public String clubs (Model model) {
		model = SMG.SchoolCouncilPanel.controllers.BaseController.setGuest (model);
		model.addAttribute ("clubs",
				clubRepo.getAll ()
						.stream ()
						.map (
								x -> ClubDetailsUntil.getFullClub (userRepo, x)
						)
						.collect (Collectors.toList ())
		);
		return "clubs";
	}
	@GetMapping(value={"/activities"})
	public String activities (Model model) {
		model = SMG.SchoolCouncilPanel.controllers.BaseController.setGuest (model);
		model.addAttribute ("activities",
				activityRepo.getAll ()
						.stream ()
						.map (
								x -> ActivityDetailsUntil.getFullActivity (userRepo, x)
						)
						.collect (Collectors.toList ())
		);
		return "activities";
	}

}