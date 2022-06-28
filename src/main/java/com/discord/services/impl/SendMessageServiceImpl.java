package com.discord.services.impl;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discord.configuration.DiscordConfig;
import com.discord.services.SendMessageService;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@Service
public class SendMessageServiceImpl implements SendMessageService {

   @Autowired
    private DiscordConfig discordConfig;

    @Override
    public void SendMessage(String channel, String message) throws LoginException, InterruptedException {
        JDABuilder jdaB =JDABuilder.createDefault(this.discordConfig.getDiscordToken());
        JDA jda = jdaB.build();
        jda.awaitReady();
        List<TextChannel> channels = jda.getTextChannelsByName(channel, false);
        TextChannel textChannel = channels.get(0);
        textChannel.sendMessage(message).queue();
        
    }

    @Override
    public void AnswerMessage(MessageReceivedEvent event) {
        // TODO Auto-generated method stub
        
    }
    
}
