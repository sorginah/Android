package com.esther.noteme.db;

/**
 * Created by Esther on 30/11/2015.
 */
public class Note {

    private Long id;
    private String state;
    private String date;
    private String title;
    private String description;
    private Float priority;

    public Note(Long id, String title, String description, String state, String date, Float priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.state = state;
        this.date = date;
        this.priority = priority;
    }

    public Note(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPriority() {
        return priority;
    }
    public void setPriority(Float priority) {
        this.priority = priority;
    }

}
