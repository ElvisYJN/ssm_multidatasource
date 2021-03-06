package com.xinhuanet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ImportResource({ "context-dao.xml"})

public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
