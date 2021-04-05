package com.To_Do_List.controller;

import com.To_Do_List.controller.form.MemberForm;
import com.To_Do_List.domain.Member;
import com.To_Do_List.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    private final MemberService memberService;

    @Autowired
    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "/loginForm";
    }

    @PostMapping("/login-check")
    public String login(MemberForm memberForm, Model model)
    {
        String nick = memberForm.getNick();
        String pw = memberForm.getPw();

        if(!nick.equals("") && !pw.equals("")) {
            Member m = memberService.findByNick(nick).get();

            if (m == null)
                return "/login?error";

            if(m.getPw().equals(pw)) {
                // login success
                return "redirect:/";
            }
            else {
                return "/login/error";
            }
        }

        return "redirect:/";
    }
}
