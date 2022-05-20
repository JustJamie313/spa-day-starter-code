package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        model.addAttribute("user",user);
        if(!user.getPassword().equals(verify)){
            model.addAttribute("error","Passwords Do Not Match!");
            return "user/add";
        }
        UserData.addUser(user);
        return "user/index";
    }
    @GetMapping
    public String userLoggedInGetRequest(Model model){
        model.addAttribute("users", UserData.getAllUsers());
        return "user/index";
    }
    @PostMapping
    public String userLoggedIn(Model model,@RequestParam User user){
        return "user/index";
    }
    @GetMapping("details/{id}")
    public String showUserDetails(Model model, @PathVariable("id") int aUserId){
        model.addAttribute("user",UserData.getUserById(aUserId));
        return "user/details";
    }
}
