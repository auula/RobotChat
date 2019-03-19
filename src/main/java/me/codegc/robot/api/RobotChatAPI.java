package me.codegc.robot.api;

import me.codegc.robot.model.Robot;
import org.springframework.web.bind.annotation.*;

/**
 * ========================== Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com @version：2.5
 * @author: Ding / 2019-03-15 11:32
 * @TODO: 聊天API ==========================
 */
@RestController
public class RobotChatAPI {
    // 📝记录当前请被调用了多少次
    private static Integer count = 0;

    // 🔍查询调用次数API
    @GetMapping("/count")
    public String chatCount() {
        return count.toString();
    }

    // 😊聊天API
    @GetMapping("/api")
    public String api(@RequestParam String mess) {
        // 先加加优化前端数据准确性
        count++;
        return Robot.Chat(mess);
    }

}
