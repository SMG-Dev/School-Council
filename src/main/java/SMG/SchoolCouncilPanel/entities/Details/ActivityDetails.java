package SMG.SchoolCouncilPanel.entities.Details;

import SMG.SchoolCouncilPanel.entities.Activity;

public class ActivityDetails extends Activity {
	private String contacts;

	public ActivityDetails (Activity c)
	{
		super (c.getId (), c.getOrganizerId (), c.getAlternateId (), c.getName (), c.getDescription (), c.getDateTime ());
	}

	public String getContacts () { return this.contacts; }
	public void setContacts (String contacts) { this.contacts = contacts; }
}
