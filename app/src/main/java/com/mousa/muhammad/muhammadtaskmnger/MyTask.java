package com.mousa.muhammad.muhammadtaskmnger;

import java.util.Date;

class MyTask {

    private String key;// key:unique id for each object. have to be....
    private String title;
    private String text;
    private int important;
    private int necessary;
    private Date createdAT;
    private Date dueDate;
    public String owner;

    public MyTask()
    {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText(String text1) {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImportant() {
        return important;
    }

    public void setImportant(int important) {
        this.important = important;
    }

    public int getNecessary() {
        return necessary;
    }

    public void setNecessary(int necessary) {
        this.necessary = necessary;
    }

    public Date getCreatedAT(Date date) {
        return createdAT;
    }

    public void setCreatedAT(Date createdAT) {
        this.createdAT = createdAT;
    }

    public Date getDueDate(Date date) {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", important=" + important +
                ", necessary=" + necessary +
                ", createdAT=" + createdAT +
                ", dueDate=" + dueDate +
                '}';
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}




