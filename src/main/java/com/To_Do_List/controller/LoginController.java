package com.To_Do_List.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("login")
    public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model)
    {
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "login";
    }
}
