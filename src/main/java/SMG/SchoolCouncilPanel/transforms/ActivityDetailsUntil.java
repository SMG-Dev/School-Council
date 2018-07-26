package SMG.SchoolCouncilPanel.transforms;

import SMG.SchoolCouncilPanel.entities.Activity;
import SMG.SchoolCouncilPanel.entities.Details.ActivityDetails;
import SMG.SchoolCouncilPanel.entities.Details.UserUtils;
import SMG.SchoolCouncilPanel.entities.User;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;

import java.util.List;

public class ActivityDetailsUntil {
	public static ActivityDetails getFullActivity (GenericRepository<User> users, Activity c) {
		ActivityDetails answer = new ActivityDetails (c);
		List<User> user = users.getBy ("id", c.getOrganizerId ());
		user.addAll (users.getBy ("id", c.getAlternateId ()));
		if (user.size () == 0)
			answer.setContacts ("");
		else
			answer.setContacts (
					user
					.stream ()
					.map (x -> x.getName () + ":" + x.getTelephone () + UserUtils.getExtendedCustom (x))
					.reduce("", String::concat)
			);
		return answer;
	}
}
