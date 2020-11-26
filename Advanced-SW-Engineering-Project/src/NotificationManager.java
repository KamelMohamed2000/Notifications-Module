import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class NotificationManager {
	public ArrayList<NotificationTemplate>notificationCategories = new ArrayList<>();

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
//
	}

	public void update(String type,String newUpdate,String whatToUpdate)
	{
		for(int i=0;i<notificationCategories.size();i++)
		{
			if(notificationCategories.get(i).getType().equalsIgnoreCase(type) && whatToUpdate.equalsIgnoreCase("context"))
			{
				notificationCategories.get(i).setContext(newUpdate);
			}
			else if(notificationCategories.get(i).getType().equalsIgnoreCase(type) && whatToUpdate.equalsIgnoreCase("type"))
			{
				notificationCategories.get(i).setType(newUpdate);
			}
		}
	}

	public void Delete(String type){

        for (int i = 0 ; i < notificationCategories.size(); i++){
            if (type.equalsIgnoreCase(notificationCategories.get(i).getType()))
                notificationCategories.remove(i);
        }
    }

}
