package com.To_Do_List.configuration;

import com.To_Do_List.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private MemberService memberService;

    @Autowired
    public SecurityConfig(MemberService memberService){
        this.memberService = memberService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
    }

    @Override
    public void configure(HttpSecurity web) throws Exception {
        web.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/items").permitAll()
                .antMatchers("/member/create").permitAll()
                .antMatchers("/members").hasRole("USER")
                .antMatchers("/member/**").hasRole("USER")
                .antMatchers("/items").hasRole("USER")
                .antMatchers("/item/**").hasRole("USER")
                .anyRequest().authenticated()
                    .and()
                .formLogin()
                .defaultSuccessUrl("/")
                    .and()
                .logout();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }
}
