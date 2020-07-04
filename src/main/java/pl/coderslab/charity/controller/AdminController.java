package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.service.UserServiceImpl;

@Controller
public class AdminController {
    private final UserServiceImpl userService;

    public AdminController(UserServiceImpl userService) {
        this.userService = userService;

    }

    @GetMapping ("admin/list")
    public String list (Model model){
        model.addAttribute("users", userService.findAllAdmins());
        return "adminList";
    }
}
