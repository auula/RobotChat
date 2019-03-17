package utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2019-03-17 10:06
 * @TODO: 这个类的描述
 * ==========================
 */
public class HttpRequestClientTest {

    @Test
    public void init() {
        System.out.println(HttpRequestClient.init());
        System.out.println(new HttpRequestClient()==HttpRequestClient.init());
    }

    @Test
    public void sendRequest() {
        System.out.println(HttpRequestClient.init().sendRequest("hello", "e9e5e4a384e94cd78ae46c30f6fb51d9"));
    }
}