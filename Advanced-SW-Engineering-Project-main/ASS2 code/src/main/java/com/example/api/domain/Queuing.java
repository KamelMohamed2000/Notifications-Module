package com.example.api.domain;

import javax.persistence.*;
import java.util.Queue;
@Entity
public class Queuing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Channels;
    private String type;
    private String Context;
    private String Placeholder;
    private String Status = "Successful";

    public String getPlaceholder() {
        return Placeholder;
    }

    public void setPlaceholder(String placeholder) {
        Placeholder = placeholder;
    }

    public Queuing() {}

    public Queuing(String channels, String type, String context,String placeholder) {
        Channels = channels;
        this.type = type;
        Context = context;
        Placeholder = placeholder;
        this.Status = "Successful";

    }

    public String getChannels() {
        return Channels;
    }

    public void setChannels(String channels) {
        Channels = channels;
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


}
