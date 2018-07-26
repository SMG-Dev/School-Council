package SMG.SchoolCouncilPanel.entities.Details;

import SMG.SchoolCouncilPanel.entities.User;

public class UserUtils {
	public static String getExtendedCustom (User c)
	{
		if (c.getCustom () == "")
			return "";
		else return ", " + c.getCustom ();
	}
}
