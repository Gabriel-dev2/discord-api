package com.discord.services;

import javax.security.auth.login.LoginException;

public interface MessageService {
    public void SendMessage(String channell, String message) throws LoginException, InterruptedException;
}
