package com.example.api.domain;

import com.example.api.dao.IQueuing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
class SendingHandler implements CommandLineRunner {


    @Autowired
    IQueuing sentRepo;

    public SendingHandler() {

    }

    @Override
    public void run(String... args) throws Exception {
        mainMenu();
    }


    public void mainMenu() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1-View All Notifications\n" +
                    "2- Send All Notifications of a specific type\n" +
                    "3- Exit");

            int option = in.nextInt();

            if (option == 1) {

                List<Queuing> queue = sentRepo.findAll();
                for (int i = 0; i < queue.size(); i++) {
                    int start = 0;
                    int end = 0;
                    for (int j = 0; j < queue.get(i).getContext().length(); j++) {
                        if (queue.get(i).getContext().charAt(j) == '{')
                            start = j;
                        else if (queue.get(i).getContext().charAt(j) == '}')
                            end = j;
                        else if (start != 0 && end != 0)
                            break;
                    }

                    String s = "";

                    for (int j = 0; j < queue.get(i).getContext().length(); j++) {
                        if (j == start) {
                            s += queue.get(i).getPlaceholder();
                            j = end + 1;
                        }
                        s += queue.get(i).getContext().charAt(j);
                    }

                    queue.get(i).setContext(s);
                    System.out.println(queue.get(i).getContext() + "\n");

                }

            } else if (option == 2) {
                in = new Scanner(System.in);
                System.out.println("Enter channel of the notifications you want to send");
                String option2 = in.nextLine();
                dequeue(option2);



            } else if (option == 3)
                break;

            else {
                System.out.println("Invalid Input\n");
            }

        }
    }


    public void dequeue(String ChannelType) {
        List<Queuing> queue = sentRepo.findAll();

        if(queue.size()==0)
        {
            System.out.println("Nothing in sending queue\n");
            return;
        }

        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).getChannels().equalsIgnoreCase(ChannelType)) {
                sentRepo.delete(queue.get(i));
            }
        }
        System.out.println("Successfully Sent\n");
    }


}
