package com.example.api.web;

import com.example.api.dao.INotificationTemplateDataAccessLayer;
import com.example.api.domain.NotificationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class NotificationController {
    @Autowired
    private INotificationTemplateDataAccessLayer types;

    @Autowired
    private INotificationTemplateDataAccessLayer notiRepo;

    //Home page
    @GetMapping
    public String welcome(){

        return "welcome";
    }
    //end of home page

    //create new temp
    @GetMapping("/create")
    public String Create(Model model){

        model.addAttribute("template" ,new NotificationTemplate());
        return "create";

    }
    @PostMapping("/create/success")
    public String saveNewTemp(Model model , NotificationTemplate notiTemp){

        List<NotificationTemplate> Types = types.findAll();

        for (int i =0 ; i < Types.size() ; i++){
            if (notiTemp.getType().equalsIgnoreCase(Types.get(i).getType())){
                return "redirect:/create" ;
            }
        }

        notiRepo.save(notiTemp);

        return "redirect:/create";
    }
    //end of deleting temp
    @GetMapping("/delete")
    public String Delete(Model model){

        model.addAttribute("deleteTemp" ,new NotificationTemplate());
        return "delete";

    }
    @PostMapping("/delete/success")
    public String deleteTemp(Model model , NotificationTemplate notiTemp){

        List<NotificationTemplate> Types = types.findAll();

        for (int i =0 ; i < Types.size() ; i++){
            if (notiTemp.getType().equalsIgnoreCase(Types.get(i).getType())){
                types.delete(Types.get(i));
            }
        }
        return "redirect:/delete";
    }
    @GetMapping("/read")
    public String Read(Model model){
        List<NotificationTemplate> rTemplate =  types.findAll();
        model.addAttribute("readTemp",rTemplate);
        return "read";

    }

    //end of deleting temp

}
