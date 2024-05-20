package hu.naplogui.model;

import java.util.Date;

public class Note {
    private String title;
    private String category;
    private String content;
    private String createdAt;
    private int userID;

    public Note() {
        this.title = "Nincs_cím";
        this.category = "Nincs_kategória";
        this.content = "Nincs_tartalom";
    }

    public Note(String title, String category, String content, String createdAt, int userID) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.createdAt = createdAt;
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public int getUserID() {
        return userID;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
