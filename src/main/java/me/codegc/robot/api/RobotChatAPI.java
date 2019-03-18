package me.codegc.robot.api;

import me.codegc.robot.model.Robot;
import org.springframework.web.bind.annotation.*;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2019-03-15 11:32
 * @TODO: 聊天API
 * ==========================
 */
@RestController
public class RobotChatAPI {

    private Integer  count = 0;


    @GetMapping("/count")
    public String chatCount(){
        return count.toString();
    }

    @GetMapping("/api")
    public String api(@RequestParam String mess){
        //先加加优化前端数据准确性
        ++this.count;
        return Robot.Chat(mess);
    }

}
