package websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class WebSocketApplication {

    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(WebSocketApplication.class);
//        app.setDefaultProperties(Collections.singletonMap("server.port", "8089"));
       SpringApplication.run(WebSocketApplication.class, args);
//        app.run();
    }

//    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(CustomApplication.class);
//        app.setDefaultProperties(Collections
//                .singletonMap("server.port", "8083"));
//        app.run(args);
//    }
}
