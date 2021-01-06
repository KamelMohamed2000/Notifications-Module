import java.io.Serializable;
import java.util.ArrayList;

public class NotificationTemplate implements Serializable {
    private String type;
    private String Context;
    private ArrayList<String> Placeholder;
    private ArrayList<String> Languages;
    private ArrayList<String> Channels;

    public ArrayList<String> getLanguages() {
        return Languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        Languages = languages;
    }

    public ArrayList<String> getChannels() {
        return Channels;
    }

    public void setChannels(ArrayList<String> channels) {
        Channels = channels;
    }

    public NotificationTemplate() {
        type="";
        Context="";
        Placeholder = new ArrayList<String>();
    }
    public NotificationTemplate(String type, String context, ArrayList<String>channels) {
        this.type = type;
        this.Context = context;
        this.Channels = channels;
        this.Placeholder = new ArrayList<String>();
        this.getPlaceholder(context);

    }

    public void getPlaceholder(String Context)
    {
        String placeholder="";
        for (int i = 0; i < Context.length(); i++) {
            if (Context.charAt(i) == '{') {
                for (int j = i; j < Context.length(); j++) {
                    placeholder += Context.charAt(j);
                    if (Context.charAt(j) == '}')
                        break;
                }
            }
            Placeholder.add(placeholder);
            placeholder = "";
        }
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

}