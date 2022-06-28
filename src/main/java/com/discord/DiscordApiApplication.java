package com.discord;

import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

@SpringBootApplication
public class DiscordApiApplication {

    @PostConstruct
    public void init() { TimeZone.setDefault(TimeZone.getTimeZone("America/Recife")); }

    public static void main(String[] args) throws LoginException {
        //JDA jda = JDABuilder.createDefault("ODMxMjQ1MjAwNjI5NTYzNDk0.Gz6xGb.Z3Ij4HS3iBZyMIWjXilRPRsaIfkPcNidGmae14").setActivity(Activity.playing("A game")).build();
        SpringApplication.run(DiscordApiApplication.class, args);
    }
}
