package com.To_Do_List.controller;

import com.To_Do_List.controller.form.MemberForm;
import com.To_Do_List.domain.Member;
import com.To_Do_List.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService)
    {
        this.memberService = memberService;
    }

    // 계정 생성
    @GetMapping("/member/create")
    public String createMember(){
        return "/member/create";
    }

    @PostMapping("/member/create")
    public String createMemberForm(MemberForm form){
        Member member = new Member();
        member.setNick(form.getNick());
        member.setPw(form.getPw());
        member.setEmail(form.getEmail());

        memberService.create(member);

        return "redirect:/";
    }

    // 계정 정보 수정
    @GetMapping("/member/update")
    public String updateMember(){
        return "/member/update";
    }

    @PostMapping("/member/update")
    public String updateMemberForm(MemberForm form){
        Member member = new Member();
        member.setId(form.getId());
        member.setNick(form.getNick());
        member.setPw(form.getPw());
        member.setEmail(form.getEmail());

        memberService.update(member);

        return "redirect:/";
    }

    // 계정 삭제
    @GetMapping("/member/delete")
    public String deleteMember(){
        return "/member/delete";
    }

    // 계정 조회 by id
    @GetMapping("/member/find")
    public String findMember(@RequestParam(name = "id", required = false, defaultValue = "0") String id,
                             @RequestParam(name = "nick", required = false, defaultValue = "") String nick,
                             Model model){
        List<Member> members = new ArrayList<>();

        if(!id.equals("0")) {
            Optional<Member> m = memberService.findByID(Long.parseLong(id));

            if (m.isPresent()) {
                Member member = m.get();
                members.add(member);
            }
        } else if(!nick.equals("")) {
            Optional<Member> m = memberService.findByNick(nick);

            if (m.isPresent()) {
                Member member = m.get();
                members.add(member);
            }
        } else {
            members = memberService.findAll();
        }

        model.addAttribute("members", members);

        return "/member/find";
    }

//    // 계정 조회 by nick
//    @GetMapping("/member/find-nick")
//    public String findMemberByNick(@RequestParam(name = "nick", required = false, defaultValue = "0") String nick, Model model){
//        Member member = new Member();
//
//        if(!nick.equals("")) {
//            Optional<Member> m = memberService.findByNick(nick);
//
//            if (m.isPresent())
//                member = m.get();
//        }
//
//        model.addAttribute("member", member);
//
//        return "/member/find-nick";
//    }
//
//    @GetMapping("/member/find-nick/{nick}")
//    public String findMemberByNick(@PathVariable(name = "nick") String nick){
//        return "/member/find-nick";
//    }
//
//    // 전체 계정 조회
//    @GetMapping("/member/find-all")
//    public String findAllMembers(Model model){
//        List<Member> members = memberService.findAll();
//        model.addAttribute("members", members);
//
//        return "/member/find-all";
//    }
}
