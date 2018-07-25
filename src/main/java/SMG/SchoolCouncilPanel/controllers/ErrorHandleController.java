package SMG.SchoolCouncilPanel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import SMG.SchoolCouncilPanel.entities.User;

import javax.servlet.http.HttpSession;

@Controller
public class ErrorHandleController {

	@GetMapping (value={"/AccessDenied"})
	public String AD403 (HttpSession session, Model model) {
		model.addAttribute ("user", session.getAttribute ("user"));
		return "errors/access_denied";
	}
}
