package SMG.SchoolCouncilPanel.controllers.ModelObjects;

public class ExitStateData<T> extends ExitState {
	private T obj;

	public ExitStateData (String message, int code, T obj) {
		super (message, code);
		this.obj = obj;
	}
}
