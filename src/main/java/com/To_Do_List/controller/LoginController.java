package com.To_Do_List.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestParam(name = "nick", required = false, defaultValue = "") String nick,
                        @RequestParam(name = "pw", required = false, defaultValue = "") String pw,
                        Model model)
    {
        model.addAttribute("nick", nick);
        model.addAttribute("pw", pw);
        return "/login";
    }
}
