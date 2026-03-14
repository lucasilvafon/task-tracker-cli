package org.example;

public class Task {

    private final int id;
    private final String description;
    private String status;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "TODO";
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void markDone() {
        this.status = "DONE";
    }
}