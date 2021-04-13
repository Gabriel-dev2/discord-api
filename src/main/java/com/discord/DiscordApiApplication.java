package com.discord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = { "io.swagger", "io.swagger.api" , "io.swagger.configuration"})
public class DiscordApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DiscordApiApplication.class);
    }

    @PostConstruct
    public void init() { TimeZone.setDefault(TimeZone.getTimeZone("America/Recife")); }

    public static void main(String[] args) {
        SpringApplication.run(DiscordApiApplication.class, args);
    }
}
