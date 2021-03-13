package com.To_Do_List.controller;

import com.To_Do_List.controller.form.MemberForm;
import com.To_Do_List.domain.Member;
import com.To_Do_List.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
    @GetMapping("/member/find-id")
    public String findMemberById(){
        return "/member/find-id";
    }

    // 계정 조회 by nick
    @GetMapping("/member/find-nick")
    public String findMemberByNick(){
        return "/member/find-nick";
    }

    // 전체 계정 조회
    @GetMapping("/member/find-all")
    public String findAllMembers(Model model){
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);

        return "/member/find-all";
    }
}
