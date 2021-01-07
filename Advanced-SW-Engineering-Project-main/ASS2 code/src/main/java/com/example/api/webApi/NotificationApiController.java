package com.example.api.webApi;


import com.example.api.dao.INotificationTemplateDataAccessLayer;
import com.example.api.dao.IQueuing;
import com.example.api.domain.NotificationTemplate;
import com.example.api.domain.Queuing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationApiController {


    @Autowired
    INotificationTemplateDataAccessLayer notirepo;
    @Autowired
    INotificationTemplateDataAccessLayer types;
    @Autowired
    IQueuing sendRepo;



    @PostMapping(value = "/createNotification" , consumes = "application/json")
    public NotificationTemplate createNotification(@RequestBody NotificationTemplate notitemp){
        List <NotificationTemplate> test =  notirepo.findAll();
        for (int i = 0 ; i< test.size();i++){
            if (test.get(i).getType().equalsIgnoreCase(notitemp.getType()))
                return null;
        }
        if (notitemp.getType().equalsIgnoreCase("") || notitemp.getContext().equalsIgnoreCase("")
        || notitemp.getChannels().equalsIgnoreCase("") || notitemp.getLanguages().equalsIgnoreCase("") ||
        notitemp.getPlaceholder().equalsIgnoreCase("")){
            return null;
        }
        return  notirepo.save(notitemp);
    }

    @GetMapping("/readNotifications")
    public List<NotificationTemplate> readNotifications(){

        return notirepo.findAll();

    }

    @PostMapping(value = "/updateNotification" , consumes = "application/json")
    public NotificationTemplate updateNotification(@RequestBody NotificationTemplate notitemp){
        NotificationTemplate test2 = new NotificationTemplate();
        List <NotificationTemplate> test =  notirepo.findAll();
        if (notitemp.getType().equalsIgnoreCase("") || notitemp.getContext().equalsIgnoreCase("")
                || notitemp.getChannels().equalsIgnoreCase("") || notitemp.getLanguages().equalsIgnoreCase("") ||
                notitemp.getPlaceholder().equalsIgnoreCase("")){
            return null;
        }
        for (int i = 0 ; i < test.size() ; i++){
            if (test.get(i).getType().equalsIgnoreCase(notitemp.getType())){

                test2 = notirepo.findById(test.get(i).getTemplateId());
                test2.setType(notitemp.getType());
                test2.setContext(notitemp.getContext());
                test2.setPlaceholder(notitemp.getPlaceholder());
                test2.setLanguages(notitemp.getLanguages());
                test2.setChannels(notitemp.getChannels());
                return notirepo.save(test2);


            }

        }
        return null;
    }

    @PostMapping(value = "/deleteNotification" , consumes = "application/json")
    public void deleteNotification(@RequestBody NotificationTemplate notitemp){
        List <NotificationTemplate> test =  notirepo.findAll();
        for (int i = 0 ; i< test.size();i++){
            if (test.get(i).getType().equalsIgnoreCase(notitemp.getType())) {
                notirepo.delete(test.get(i));
                break;
            }
        }

    }

    @PostMapping(value = "/sendNotification" , consumes = "application/json")
    public void sendNotification(@RequestBody Queuing queue)
    {
        List<NotificationTemplate> Types = types.findAll();

        for(int i=0;i<Types.size();i++)
        {
            if(Types.get(i).getType().equalsIgnoreCase(queue.getType()) &&
                    Types.get(i).getChannels().equalsIgnoreCase(queue.getChannels()))
            {
                queue.setContext(Types.get(i).getContext()) ;
                sendRepo.save(queue);
                break;
            }
        }
    }




}
