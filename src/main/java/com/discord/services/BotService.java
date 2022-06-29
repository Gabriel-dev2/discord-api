package com.discord.services;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;

public interface BotService{
    
    public void createListener(JDA jda) throws LoginException;
}
