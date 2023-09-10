package com.example.taskmaster.api.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private LocalDateTime due_date;
    private int user_id;

    public Task() {}

    public Task(int id, String title, String description, LocalDateTime due_date, int user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.due_date = due_date;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() { return description;}

    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getDue_date() { return due_date; }

    public void setDue_date(LocalDateTime due_date) { this.due_date = due_date; }

    public int getUser_id() { return user_id; }

    public void setUser_id(int user_id) { this.user_id = user_id; }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + "," +
                ", description='" + description + ',' +
                ", due date='" + due_date + ',' +
                '}';
    }
}
