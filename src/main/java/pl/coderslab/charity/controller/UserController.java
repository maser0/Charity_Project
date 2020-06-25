package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Model.CurrentUser;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.interfaces.UserService;

@Controller
public class UserController {
    private final UserService userService;
    private final pl.coderslab.charity.service.UserService userServ;

    public UserController(UserService userService, pl.coderslab.charity.service.UserService userServ) {
        this.userService = userService;
        this.userServ = userServ;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.saveUser(user);
        return "admin";
    }


    @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }


    @GetMapping("/register")
    public String reg(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String post(@ModelAttribute User user) {
        userService.saveUser(user);
        return "index";
    }


    @GetMapping("/user/list")
    public String inst(Model model) {
        model.addAttribute("users", userServ.findAll());
        return "userList";
    }

    @GetMapping("/user/{id}")
    public String edit(@PathVariable long id, Model model){
        User user = userServ.read(id);
        model.addAttribute("user", user);
        return "register";
    }
//
//    @GetMapping ("/user/create")
//    public String create(Model model){
//        model.addAttribute("user", new User());
//        return "register";
//    }

    @GetMapping("user/delete/{id}")
    public String delete(@PathVariable long id) {
        User userToDelete = userServ.read(id);
        userServ.delete(userToDelete);
        return "redirect:/user/list";
    }


}
