package SMG.SchoolCouncilPanel.controllers;

import SMG.SchoolCouncilPanel.entities.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;


@Controller
public class HomeController {

	@Autowired
	GenericRepository<Club> clubRepo;

	@GetMapping(value={"","/","/home"})
	public String home (Model model) {
		model = SMG.SchoolCouncilPanel.controllers.BaseController.setGuest (model);

		return "home";
	}

}