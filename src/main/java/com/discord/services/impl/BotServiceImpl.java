package com.discord.services.impl;

import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Service;

import com.discord.services.BotService;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

@Service
public class BotServiceImpl extends ListenerAdapter implements BotService {

    @Override
    public void createListener(String token) throws LoginException {
        JDABuilder.createLight(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
        .addEventListeners(new BotServiceImpl())
        .setActivity(Activity.playing("Type !ping"))
        .build();
    }
    
}
