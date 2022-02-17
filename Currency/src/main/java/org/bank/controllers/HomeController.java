package org.bank.controllers;

import org.bank.entity.User;
import org.bank.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    String index(Model model) {
        model.addAttribute("users",userService.findAll());
        return "redirect:/user";
    }

    @GetMapping("/addUser")
    public String user() {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String index(User user) {
        userService.addUser(user);
        return "redirect:/";
    }
}
