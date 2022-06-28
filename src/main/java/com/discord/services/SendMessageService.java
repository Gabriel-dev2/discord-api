package com.discord.services;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface SendMessageService {
    public void SendMessage(String channell, String message) throws LoginException, InterruptedException;

    public void AnswerMessage(MessageReceivedEvent event);
}
