package com.divyansh.createit.pojo;

public class Task {

    private String description;
    private boolean isCompleted;
    private int priority;

    public Task(String description, boolean isCompleted, int priority) {
        this.description = description;
        this.isCompleted = isCompleted;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean getCompleted() {
        return isCompleted;
    }
}
