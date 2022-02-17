package org.bank.controllers;

import lombok.AllArgsConstructor;
import org.bank.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @GetMapping("/delete")
    String add(@RequestParam("id") Integer id) {
        userService.remove(id);
        return ("redirect:/user");
    }


}
