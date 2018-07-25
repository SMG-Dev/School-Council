package SMG.SchoolCouncilPanel.controllers.REST_API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import SMG.SchoolCouncilPanel.controllers.ModelObjects.ExitState;
import SMG.SchoolCouncilPanel.entities.Course;
import SMG.SchoolCouncilPanel.entities.Track;
import SMG.SchoolCouncilPanel.entities.User;
import SMG.SchoolCouncilPanel.entities.Video;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping (value="/api")
public class UserSessionController {
	@Autowired
	GenericRepository<User> repo;

	@Autowired
	PasswordEncoder passwordEncoder;

	private void removeSession (HttpSession session) {
			session.invalidate ();
	}

	private void setUserSession (HttpSession session, User user) {
		session.setAttribute("user", user);
	}

	@RequestMapping("/logout")
	public String logout (HttpSession session, Model model) {
		this.removeSession (session);
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login (HttpSession session, @ModelAttribute ("user") User user, Model model) throws Exception {
		List<User> full_user = repo.getBy ("email", user.getEmail());

		if (full_user.size () == 1 && passwordEncoder.matches (user.getPassword (), full_user.get(0).getPassword ())) {
			this.setUserSession (session, full_user.get(0));
			return "redirect:/";
		} else {
			model.addAttribute("message", "Login failed. Try again.");
			return "redirect:/user/login";
		}
	}

	@PostMapping("/register")
	public String register (HttpSession session, @ModelAttribute ("user") User user, @RequestParam("password_confirm") String confirmPassword, Model model) throws Exception {

		user.setRole ("Student");

		List<User> full_user_by_email = repo.getBy ("email", user.getEmail());
		List<User> full_user_by_username = repo.getBy ("username", user.getUsername ());

		if (full_user_by_email.isEmpty () && full_user_by_username.isEmpty () && user.getPassword ().equals (confirmPassword)) {
			user.setPassword (passwordEncoder.encode (confirmPassword));
			final User user1 = repo.create (user);
			this.setUserSession (session, user1);

			return "redirect:/";
		}
		else {
			model.addAttribute("message", "Login failed. Try again.");
			return "redirect:/user/register";
		}
	}
}
