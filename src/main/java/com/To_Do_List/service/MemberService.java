package com.To_Do_List.service;

import com.To_Do_List.domain.Member;
import com.To_Do_List.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public long create(Member member){
        memberRepository.createMember(member);
        return member.getId();
    }

    public long update(Member member){
        memberRepository.updateMember(member);
        return member.getId();
    }

    public Optional<Member> findByID(long id){
        return memberRepository.findMemberById(id);
    }

    public Optional<Member> findByNick(String nick){
        return memberRepository.findMemberByNick(nick);
    }

    public List<Member> findAll(){
        return memberRepository.findAllMembers();
    }

    public int nickCheck(String nick) {
        return memberRepository.nickCheck(nick);
    }

    @Override
    public UserDetails loadUserByUsername(String nick) throws UsernameNotFoundException {
        Member member = memberRepository.findMemberByNick(nick).orElseThrow(() -> new UsernameNotFoundException("존재하지 않은 사용자"));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pw = encoder.encode(member.getPw());

        return new User(member.getNick(), pw, authorities);
    }
}
