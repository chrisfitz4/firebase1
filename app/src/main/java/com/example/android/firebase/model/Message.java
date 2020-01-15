package com.example.android.firebase.model;

import androidx.annotation.NonNull;

public class Message {

    private String messageTitle;
    private String messageDate;
    private String userName;
    private String messageContent;


    public Message(){
        messageTitle = "title";
        messageDate = "date";
        userName = "userName";
        messageContent = "content";
    }

    public Message(String messageContent, String messageDate, String messageTitle, String userName) {
        this.messageTitle = messageTitle;
        this.messageDate = messageDate;
        this.userName = userName;
        this.messageContent = messageContent;
    }

    /////////////getters and setters//////
    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }


    @NonNull
    @Override
    public String toString() {
        return userName+" said "+messageContent+" on "+messageDate+" in "+messageTitle;
    }
}
