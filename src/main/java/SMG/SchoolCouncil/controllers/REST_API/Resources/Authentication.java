package SMG.SchoolCouncilPanel.controllers.REST_API.Resources;

import SMG.SchoolCouncilPanel.entities.User;

import javax.servlet.http.HttpSession;

public class Authentication {
	public static boolean isAdmin (HttpSession session)
	{
		if (session.getAttribute ("user") == null)
			return false;
		if (((User)session.getAttribute ("user")).getRole () != "Admin")
			return false;
		return true;
	}
}
