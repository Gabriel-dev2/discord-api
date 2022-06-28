package com.discord.services;

import javax.security.auth.login.LoginException;

public interface BotService{
    
    public void createListener(String token) throws LoginException;
}
