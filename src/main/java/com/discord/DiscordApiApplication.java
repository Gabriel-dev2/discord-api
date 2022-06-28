package com.discord;

import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscordApiApplication {

    @PostConstruct
    public void init() { TimeZone.setDefault(TimeZone.getTimeZone("America/Recife")); }

    public static void main(String[] args) throws LoginException {
        SpringApplication.run(DiscordApiApplication.class, args);
    }
}
