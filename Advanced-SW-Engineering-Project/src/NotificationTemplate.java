import java.util.ArrayList;

public class NotificationTemplate {
    private String type;
    private String Context;
    private ArrayList<String> Placeholder;
    private String email;

    public NotificationTemplate() {
        type="";
        Context="";
        Placeholder = new ArrayList<String>();
        email="";
    }

    public NotificationTemplate(String type, String context, ArrayList<String> Placeholder) {
        this.type = type;
        this.Context = context;
        this.Placeholder = Placeholder;
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

    public ArrayList<String> getPlaceholder() {
        return Placeholder;
    }

    public void setPlaceholder(ArrayList<String> placeholder) {
        Placeholder = placeholder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}