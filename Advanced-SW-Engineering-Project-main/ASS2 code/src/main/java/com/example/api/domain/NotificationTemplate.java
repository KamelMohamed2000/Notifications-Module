package com.example.api.domain;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;


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
    private String status = "failed";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NotificationTemplate(){


    }

    public NotificationTemplate(String type, String context, String placeholder,
                                String languages, String channels) {
        this.type = type;
        Context = context;
        Placeholder = placeholder;
        Languages = languages;
        Channels = channels;
        this.status = "Failed";

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

    public long getTemplateId() {
        return templateId;
    }


}