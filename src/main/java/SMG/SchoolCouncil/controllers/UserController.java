package SMG.SchoolCouncilPanel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/user"})
public class UserController {

	@GetMapping(value={"/login"})
	public String login (Model model) {
		model = BaseController.setGuest (model);
		return "login";
	}

	@GetMapping(value={"/register"})
	public String register (Model model) {
		model = BaseController.setGuest (model);
		return "register";
	}

}