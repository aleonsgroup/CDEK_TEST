package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "TASK")
@Entity
public class Task {
    @Id
    @Column(name = "NUMBER")
    private Long numberTask;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "TIME")
    private String time;
    @Column(name = "IS_COMPLETED")
    private Boolean isCompleted;

    public Long getNumberTask() {
        return numberTask;
    }

    public void setNumberTask(Long numberTask) {
        this.numberTask = numberTask;
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
