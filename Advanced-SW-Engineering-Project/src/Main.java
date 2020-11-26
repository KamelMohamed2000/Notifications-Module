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
		int choice;
		NotificationManager notificationManager = new NotificationManager();
		while (true)
		{
			System.out.println("Enter your choice");
			System.out.println("1-Creat Template");
			System.out.println("2-Update Template");
			System.out.println("3-Read Template");
			System.out.println("4-Delete Template");
			System.out.println("5-exit");

			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
			in.skip("\n");
			if(choice == 1)
			{
				String type;
				String Context;
				String placeholder = "";
				ArrayList<String>Placeholders = new ArrayList<String>();
				int numberOfPlaceholders;
				System.out.println("Enter Template type");
				type = in.nextLine();
				System.out.println("Enter Template Context ");
				Context = in.nextLine();
				for(int i=0;i<Context.length();i++)
				{
					if(Context.charAt(i) == '{')
					{
						for(int j=i ;j<Context.length();j++)
						{
							placeholder +=Context.charAt(j);
							if(Context.charAt(j)=='}')
								break;
						}
					}
					Placeholders.add(placeholder);
					placeholder="";
				}
				NotificationTemplate template = new NotificationTemplate(type,Context,Placeholders);
				notificationManager.notificationCategories.add(template);
			}
			else if (choice == 2)
			{
				String whatToUpdate;
				String typeOfTemplate;
				String newUpdate;
				System.out.println("What Type of tempelates to do you want to update?");
				typeOfTemplate = in.nextLine();
				System.out.println("What do you want to update? Type or Context");
				whatToUpdate = in.nextLine();
				System.out.println("Enter your new Update");
				newUpdate = in.nextLine();
				notificationManager.update(typeOfTemplate, newUpdate, whatToUpdate);
			}
			else if(choice ==3)
			{
				//Read function still to be implemented
			}
			else if(choice == 4)
			{
				String typeOfTemplate;
				System.out.println("Which type of template do you want to remove");
				typeOfTemplate = in.nextLine();
				notificationManager.Delete(typeOfTemplate);
			}
			else if(choice ==5)
			{
				//SerializationCode
				break;

			}

		}
//		
//		ArrayList<Character> Plholder = new ArrayList<Character>(
//				Arrays.asList('x','y'));
//		NotificationTemplate notificationTemplate = new 
//				NotificationTemplate("Confirmation"
//						, "Dear {x} , your booking of the {y} is confirmed. thanks for using our store :) "
//						, Plholder
//						,"waleedkamal1999@gmail.com");
//		
//		notificationManager.create(notificationTemplate);
//		
//		
//		ArrayList<Character> Plholder2 = new ArrayList<Character>(
//				Arrays.asList('x','y'));
//		NotificationTemplate notificationTemplate1 = new 
//				NotificationTemplate("Checking"
//						, "Darling {x} , your calling of the {y} is confirmed. thanks for using our store :( "
//						, Plholder2
//						,"ziadamr@gmail.com");
//		
//		notificationManager.create(notificationTemplate1);


	}

}
