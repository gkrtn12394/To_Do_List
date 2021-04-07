package com.To_Do_List.domain;

import java.util.Date;

public class Item {
    private long id;
    private String title;
    private String note;
    private String status;
    private Date regDate;
    private Date dueDate;
    private String userNick;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getUserNick() {
        return userNick;
    }
    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
}
