package SMG.SchoolCouncilPanel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import SMG.SchoolCouncilPanel.entities.User;

@Controller
public class BaseController {

	public static Model setGuest (Model model) {
		if (!model.containsAttribute ("user"))
			model.addAttribute ("user", new User ());

		return model;
	}
}