package SMG.SchoolCouncilPanel.transforms;

import SMG.SchoolCouncilPanel.entities.Club;
import SMG.SchoolCouncilPanel.entities.Details.ClubDetails;
import SMG.SchoolCouncilPanel.entities.Details.UserUtils;
import SMG.SchoolCouncilPanel.entities.User;
import SMG.SchoolCouncilPanel.repositories.base.GenericRepository;

import java.util.List;

public class ClubDetailsUntil {
	public static ClubDetails getFullClub (GenericRepository<User> users, Club c) {
		ClubDetails answer = new ClubDetails (c);
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
