package utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2019-03-17 09:39
 * @TODO: request网络请求客户端工具类
 * ==========================
 */
@Slf4j
public class HttpRequestClient {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static HttpRequestClient httpRequestClient = null;

    public static HttpRequestClient init() {
        return httpRequestClient == null ? httpRequestClient = new HttpRequestClient() : httpRequestClient;
    }

    public String sendRequest(String mess, String key) {

        BufferedReader reader = null;
        StringBuffer sb = null;

        try {
            String INFO = URLEncoder.encode(mess, "utf-8");

            String getURL = "http://www.tuling123.com/openapi/api?key=" + key + "&info=" + INFO;
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

