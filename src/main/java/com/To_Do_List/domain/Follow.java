package com.To_Do_List.domain;

public class Follow {
    private long id;
    private String toNick;
    private String fromNick;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToNick() {
        return toNick;
    }

    public void setToNick(String toNick) {
        this.toNick = toNick;
    }

    public String getFromNick() {
        return fromNick;
    }

    public void setFromNick(String fromNick) {
        this.fromNick = fromNick;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

