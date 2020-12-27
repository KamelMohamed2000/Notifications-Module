package com.example.api.domain;

import java.util.ArrayList;




public class NotificationManager {
    public ArrayList<NotificationTemplate>notificationCategories = new ArrayList<>();

    public NotificationManager() {

    }

    public NotificationManager(ArrayList<NotificationTemplate> notificationCategories) {
        this.notificationCategories = notificationCategories;
    }

    public ArrayList<NotificationTemplate> getNotificationCategories() {
        return notificationCategories;
    }

    public void setNotificationCategories(ArrayList<NotificationTemplate> notificationCategories) {
        this.notificationCategories = notificationCategories;
    }
}
