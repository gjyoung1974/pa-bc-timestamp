package com.gyoung.security.crypto.pki.timestamp.timestamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

//application entry point
@SpringBootApplication
public class TimestampApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeStampServlet.class, args);
    }
}
