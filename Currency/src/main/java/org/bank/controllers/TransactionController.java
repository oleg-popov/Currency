package org.bank.controllers;

import lombok.AllArgsConstructor;
import org.bank.entity.Transaction;
import org.bank.entity.User;
import org.bank.service.TransactionService;
import org.bank.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

@Controller
@AllArgsConstructor
@RequestMapping("/exchange")
public class TransactionController {
    private final TransactionService trServise;
    private final UserService userService;


    @GetMapping("/{id}")
    public String list(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "exchange";
    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getExchange(@RequestBody Transaction transaction, @PathVariable Integer id){
        transaction.setCreated(getDate());
        User user = userService.findById(id);
        if (user != null){
            user.addTransaction(transaction);
            trServise.addTransaction(transaction);
        }
        return "redirect:/";
    }
    public String getDate(){
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return date.format(new Date());
    }
}
