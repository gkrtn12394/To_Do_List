package com.To_Do_List.controller.form;

public class MemberForm {
    private long id;
    private String nick;
    private String pw;
    private String email;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getNick() { return nick; }

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
}
