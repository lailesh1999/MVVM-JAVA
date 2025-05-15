package com.example.mvvm_example1.model;

public class TodoItems {

    private String title;
    private String dateTime;
    private String tag; // e.g., "Work"
    private int status; // 0 = pending, 1 = completed
    private int priorityColor; // color resource id

    public TodoItems(String title,String dateTime,String tag,int status,int priorityColor){
        title = this.title;
        dateTime = this.dateTime;
        tag = this.tag;
        status = this.status;
        priorityColor = this.priorityColor;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPriorityColor() {
        return priorityColor;
    }

    public void setPriorityColor(int priorityColor) {
        this.priorityColor = priorityColor;
    }
}
