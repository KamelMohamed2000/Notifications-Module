package com.example.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class NotificationTemplate  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long templateId;
    private String type;
    private String Context;
    private String Placeholder;
    private String Languages;
    private String Channels;

    public NotificationTemplate(){


    }

    public NotificationTemplate(String type, String context, String placeholder,
                                String languages, String channels) {
        this.type = type;
        Context = context;
        Placeholder = placeholder;
        Languages = languages;
        Channels = channels;
    }
    public NotificationTemplate(String context, String placeholder,
                                String languages, String channels) {
        Context = context;
        Placeholder = placeholder;
        Languages = languages;
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

    public String getPlaceholder() {
        return Placeholder;
    }

    public void setPlaceholder(String placeholder) {
        Placeholder = placeholder;
    }

    public String getLanguages() {
        return Languages;
    }

    public void setLanguages(String languages) {
        Languages = languages;
    }

    public String getChannels() {
        return Channels;
    }

    public void setChannels(String channels) {
        Channels = channels;
    }
}