package com.romedawg.rome.Domain;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="task")
public class Task {

    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  long Id;
    private String summary;
    private String description;
    private Status status;
    private int priority;

    public enum Status {
        CREATED, ASSIGNED, CANCELED, COMPLETED
    }

    protected Task(){}

    public Task(long Id, String summary, String description, Status status, int priority ){
        this.Id = Id;
        this.summary = summary;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public long getId() {
        return Id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task [id=" + Id + ", summary=" + summary + ", description=" + description + ", status=" + status
                + ", priority=" + priority + "]";
    }
}
