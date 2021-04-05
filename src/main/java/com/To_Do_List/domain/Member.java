package com.To_Do_List.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Member {
    private long id;
    private String nick;
    private String pw;
    private String email;
    private String role;

    public Member() {
        id = 0l;
        nick = "";
        pw = "";
        email = "";
        role = "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
