package com.nhnacademy.springbootstudent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AccountWebController {
    @GetMapping("/web/accounts/{id}")
    public String getAccounts(@PathVariable Long id,
                             Model model){
        model.addAttribute("account", new Account(1L, "12342", 1000));
        return "account";
    }
}