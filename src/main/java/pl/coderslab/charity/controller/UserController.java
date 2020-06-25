package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Model.CurrentUser;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.interfaces.UserService;
import pl.coderslab.charity.service.UserServiceImpl;

@Controller
public class UserController {
    private final UserServiceImpl userService;


    public UserController(UserServiceImpl userService) {
        this.userService = userService;

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


    @GetMapping("/admin/user/list")
    public String inst(Model model) {

        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("/admin/user/{id}")
    public String edit(@PathVariable long id, Model model){
        User user = userService.read(id);
        model.addAttribute("user", user);
        return "register";
    }


    @GetMapping("/admin/user/enabled/{id}")
    public String disable(@PathVariable long id) {
        User userToDisable = userService.read(id);
        userService.disable(userToDisable);
        return "redirect:/admin/user/list";
    }

    @GetMapping("/user")
    public String profile(@AuthenticationPrincipal CurrentUser customUser, Model model){
        User entityUser = customUser.getUser();
        User user = userService.read(entityUser.getId());
        model.addAttribute("user", user);
        return "register";
    }


}
