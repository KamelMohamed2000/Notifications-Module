import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		NotificationManager notificationManager = new NotificationManager();
		int choice;
		while (true) {
			System.out.println("Enter your choice");
			System.out.println("1-Creat Template");
			System.out.println("2-Update Template");
			System.out.println("3-Read Template");
			System.out.println("4-Delete Template");
			System.out.println("5-exit");

			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
			in.skip("\n");
			if (choice == 1) {
				ArrayList<String>channels= new ArrayList<>();
				ArrayList<String>languages= new ArrayList<>();
				String type;
				String Context;
				String channel;
				String lang;
				int numberOfPlaceholders,numberOfChannels,numberOfLanguages;
				System.out.println("Enter Template type");
				type = in.nextLine();
				System.out.println("Enter Template Context ");
				Context = in.nextLine();
				System.out.println("How many channels do you want to add?");
				numberOfChannels = in.nextInt();
				for(int i=0;i<numberOfChannels;i++)
				{
					System.out.println("Enter a Channel");
					channel=in.next();
					channels.add(channel);
				}
				System.out.println("How many languages do you want to add?");
				numberOfLanguages = in.nextInt();
				for(int i=0;i<numberOfLanguages;i++)
				{
					System.out.println("Enter a channel");
					lang = in.next();
					languages.add(lang);
				}

				NotificationTemplate template = new NotificationTemplate(type, Context,channels);
				notificationManager.notificationCategories.add(template);

			} else if (choice == 2) {
				String whatToUpdate;
				String typeOfTemplate;
				String newUpdate;
				System.out.println("What Type of tempelates to do you want to update?");
				typeOfTemplate = in.nextLine();
				System.out.println("What do you want to update? Type or Context, or Channels, or languages");
				whatToUpdate = in.nextLine();
				System.out.println("Enter your new Update");
				newUpdate = in.nextLine();
				notificationManager.update(typeOfTemplate, newUpdate, whatToUpdate);
			} else if (choice == 3) {
				String whatToRead;
				System.out.println("What Type of notifications you Want To Read");
				whatToRead = in.nextLine();
				notificationManager.Read(whatToRead);
			} else if (choice == 4) {
				String typeOfTemplate;
				System.out.println("Which type of template do you want to remove");
				typeOfTemplate = in.nextLine();
				notificationManager.Delete(typeOfTemplate);
			} else if (choice == 5) {
				FileOutputStream file = null;
				try {
					file = new FileOutputStream("Notifications.txt");
					ObjectOutputStream out = new ObjectOutputStream(file);
					out.writeObject(notificationManager.notificationCategories);
					System.exit(0);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

	}
}
