package com.discord.services;

import javax.security.auth.login.LoginException;

public interface BotService{
    
    public boolean sendMessage(String channel, String message) throws LoginException, InterruptedException;
}
