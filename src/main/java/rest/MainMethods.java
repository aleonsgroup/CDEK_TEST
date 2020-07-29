package rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity getTasksForCall(){
        return ResponseEntity.ok("tasks");
    }

}
