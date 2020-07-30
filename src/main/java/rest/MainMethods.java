package rest;

import com.google.gson.Gson;
import dao.TaskDAO;
import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/mainMethods")
public class MainMethods {

    @Autowired
    private TaskDAO taskDAO;

    //Я не стал заморачиваться с GSON и сделал JSON вручную =)
    @RequestMapping(method = RequestMethod.POST, value = "/acceptMessage", produces = "json/application")
    public ResponseEntity acceptMessage(@RequestBody Map<String,Object> body){
        if (body.get("message")!=null){
            String response = "Сообщение отправлено";
            if(body.get("message").equals("Не успеваю")){
                Task task = new Task();
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    task.setDate(format.parse(format.format(new Date())));
                    LocalTime now = LocalTime.now();
                    task.setTime(now.getHour()+":"+now.getMinute()+":"+now.getSecond());
                    task.setCompleted(false);
                    response = "Задача создана";
                } catch (ParseException e) {
                    e.printStackTrace();
                    response = "Ошибка даты";
                }
                taskDAO.add(task);
            }
            return ResponseEntity.ok("{\"status\":\""+response+"\"}");
        }
        else{
            return ResponseEntity.badRequest().body("{\"error\":\"нет обязательного поля message\"}");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasksForCall")
    public ResponseEntity getTasksForCall(
            @RequestParam(value="fromDate", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,
            @RequestParam(value="toDate", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate,
            @RequestParam(value="numberTask", required=false) Integer numberTask){
        List<Task> tasks;
        if(numberTask == null){
            tasks = taskDAO.get(fromDate, toDate);
        }
        else {
            tasks = taskDAO.get(fromDate, toDate, numberTask);
        }
        return ResponseEntity.ok(new Gson().toJson(tasks));
    }

}
