package dao;

import model.Task;

import java.util.Date;
import java.util.List;

public interface TaskDAO {

    void add(Task task);
    void delete(Long number);
    void update(Task task);
    List<Task> get(Date fromDate, Date toDate);
    List<Task> get(Date fromDate, Date toDate, Integer number);
    Task getByNumber(Long number);

}
