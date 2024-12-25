package com.client;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@Configuration
public class ThinkerCodeStarter {

    private static final Logger logger = Logger.getLogger(ThinkerCodeStarter.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ThinkerCodeStarter.class, args);

        ConfigurableEnvironment environment = context.getEnvironment();
        String port = environment.getProperty("server.port");
        String appName = environment.getProperty("spring.application.name");
        System.out.println("port:" + port + "|");
        System.out.println("appName:" + appName);
    }
}
