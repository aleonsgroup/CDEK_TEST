package model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "TASK")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "NUMBER")
    private Integer numberTask;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "TIME")
    private String time;
    @Column(name = "IS_COMPLETED")
    private Boolean isCompleted;

    public Task() {
    }

    public Task(Date date, String time, Boolean isCompleted) {
        this.date = date;
        this.time = time;
        this.isCompleted = isCompleted;
    }

    public Integer getNumberTask() {
        return numberTask;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
