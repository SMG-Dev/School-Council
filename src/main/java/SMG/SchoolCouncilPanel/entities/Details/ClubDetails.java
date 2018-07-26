package SMG.SchoolCouncilPanel.entities.Details;

import SMG.SchoolCouncilPanel.entities.Club;

public class ClubDetails extends Club {
	public String contacts;

	public ClubDetails (Club c)
	{
		super (c.getId (), c.getOrganizerId (), c.getAlternateId (), c.getName (), c.getDescription (), c.getDateTime ());
	}

	public String getContacts () { return this.contacts; }
	public void setContacts (String contacts) { this.contacts = contacts; }
}
