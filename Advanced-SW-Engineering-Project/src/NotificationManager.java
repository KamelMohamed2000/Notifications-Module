import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class NotificationManager {
	private ArrayList<NotificationTemplate>notificationCategories = new ArrayList<>();

	public NotificationManager() {
		try { 

			FileInputStream file = new FileInputStream ("Notifications.txt"); 
			ObjectInputStream in = new ObjectInputStream (file);

			notificationCategories = (ArrayList<NotificationTemplate>)in.readObject();
		}
		
		catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
		

	}	

	public void create (NotificationTemplate notificationTemplate) {
	
		notificationCategories.add(notificationTemplate);
 
//		FileOutputStream file = null;------------------------> serilization
//        try {
//            file = new FileOutputStream("Notifications.txt");
//            ObjectOutputStream out = new ObjectOutputStream(file);
//            out.writeObject(notificationCategories);
//        } catch (IOException e) {
//            e.printStackTrace();
//      }

	
	}

}
