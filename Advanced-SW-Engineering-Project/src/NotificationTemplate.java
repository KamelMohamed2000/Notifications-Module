import java.util.ArrayList;

public class NotificationTemplate {
    private String type;
    private String Context;
    private ArrayList<Character> Placeholder;
    private String email;

    public NotificationTemplate() {
        type="";
        Context="";
        Placeholder = new ArrayList<Character>();
        email="";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public ArrayList<Character> getPlaceholder() {
        return Placeholder;
    }

    public void setPlaceholder(ArrayList<Character> placeholder) {
        Placeholder = placeholder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}