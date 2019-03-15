package me.codegc.robot.model;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2019-03-15 11:12
 * @TODO: 机器人
 * <p>
 * ==========================
 */
@Slf4j
public class Robot {

    private static final String key = "e9e5e4a384e94cd78ae46c30f6fb51d9";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static Robot robot = null;

    public static void init() {
        if (robot == null) {
            robot = new Robot();
        }
    }

//    public static Robot init() {
//        return  new Robot();
//    }


    public static String Chat(String mess) {
        return JSONObject.parseObject(robot.sendMess(mess), Map.class).get("content").toString();
    }


    private String sendMess(String mess) {

        BufferedReader reader = null;
        StringBuffer sb = null;
        try {
            String INFO = URLEncoder.encode(mess, "utf-8");

            String getURL = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=" + INFO;
            URL getUrl = new URL(getURL);
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();

            // 取得输入流，并使用Reader读取
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            sb = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            // 断开连接
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
            sb.append("我需要休息一下~我很累了~请稍后再找我吧~");
            logger.error("API连接获取异常！");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
