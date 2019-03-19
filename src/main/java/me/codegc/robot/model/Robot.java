package me.codegc.robot.model;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.HttpRequestClient;

import java.util.Map;

/**
 * ========================== Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com @version：2.3
 * @author: Ding / 2019-03-15 11:12
 * @TODO: 机器人类
 *        <p>
 *        ==========================
 */
@Slf4j
public class Robot {

    private static final String key = "e9e5e4a384e94cd78ae46c30f6fb51d9";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // private static Robot robot = null;
    //
    // public static void init() {
    // if (robot == null) {
    // robot = new Robot();
    // }
    // }

    /**
     * 更新了调用接口
     * 
     * @param mess
     * @return
     */
    public static String Chat(String mess) {
        return JSONObject.parseObject(HttpRequestClient.init().sendRequest(mess, Robot.key), Map.class).get("text")
                .toString();
    }

}
