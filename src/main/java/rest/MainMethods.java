package rest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping(value = "/mainMethods")
public class MainMethods {

    @RequestMapping(method = RequestMethod.POST, value = "/acceptMessage", produces = "json/application")
    public ResponseEntity acceptMessage(@RequestBody Map<String,Object> body){
        if (body.get("message")!=null){
            return ResponseEntity.ok(body.get("message"));
        }
        else{
            return ResponseEntity.badRequest().body("нет обязательного поля message");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasksForCall")
    public ResponseEntity getTasksForCall(
            @RequestParam(value="fromDate", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,
            @RequestParam(value="toDate", required=true) @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate,
            @RequestParam(value="numberTask", required=false) Long numberTask){
        return ResponseEntity.ok("tasks");
    }

}
