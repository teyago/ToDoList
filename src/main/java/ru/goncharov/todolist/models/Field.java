package ru.goncharov.todolist.models;

public class Field {

    private int id;

    private String task;

    private String updatedTask;

    private boolean checkBox;

    public Field() {
    }

    public Field(int id, String task, String updatedTask, boolean checkBox) {
        this.id = id;
        this.task = task;
        this.updatedTask = updatedTask;
        this.checkBox = checkBox;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getUpdatedTask() {
        return updatedTask;
    }

    public void setUpdatedTask(String updatedTask) {
        this.updatedTask = updatedTask;
    }

    public boolean getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }

}
