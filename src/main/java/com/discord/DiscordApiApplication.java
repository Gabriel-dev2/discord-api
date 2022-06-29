package com.discord;

import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.discord.services.impl.BotServiceImpl;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

@SpringBootApplication
public class DiscordApiApplication {
    public static JDA jda;

    @PostConstruct
    public void init() { TimeZone.setDefault(TimeZone.getTimeZone("America/Recife")); }

    public static void main(String[] args) throws LoginException {
        String discordToken = System.getenv("DISCORD_TOKEN");

        jda = JDABuilder.createLight(discordToken, GatewayIntent.GUILD_MESSAGES)
        .setActivity(Activity.watching("South Park")).build();
        jda.addEventListener(new BotServiceImpl());
        jda.setAutoReconnect(false);

        SpringApplication.run(DiscordApiApplication.class, args);
    }
}
