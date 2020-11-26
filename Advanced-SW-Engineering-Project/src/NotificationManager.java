import java.util.ArrayList;

public class NotificationManager {
    private ArrayList<NotificationTemplate>notificationCategories;

    NotificationManager(){
        ArrayList<NotificationTemplate>notificationCategories = new ArrayList<NotificationTemplate>();
    }

    public ArrayList<NotificationTemplate> getNotificationCategories() {
        return notificationCategories;
    }



    public void Delete(String type){

        for (int i = 0 ; i < notificationCategories.size(); i++){
            if (type.equalsIgnoreCase(notificationCategories.get(i).getType()))
                notificationCategories.remove(i);
        }
    }
}
