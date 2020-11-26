import java.util.ArrayList;

public class NotificationTemplate {
	public String type;
	public String Context;
	public ArrayList<Character> Placeholder;
	public String email;
	
	public NotificationTemplate() {
		type="";
		Context="";
		Placeholder = new ArrayList<Character>();
		email="";
	}
}
