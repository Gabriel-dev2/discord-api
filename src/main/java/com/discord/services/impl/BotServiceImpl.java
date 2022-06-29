package com.discord.services.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Service;

import com.discord.services.BotService;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Service
public class BotServiceImpl extends ListenerAdapter implements BotService {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();

        if (msg.getContentRaw().equals("!ping")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("🏓 Pong!").queue();
            
 
        }

        if (msg.getContentRaw().equals("!hours")) {
            MessageChannel channel = event.getChannel();
            LocalTime now = LocalTime.now();
            channel.sendMessage("⌚ It's " + now + " !").queue();
        }

        if (msg.getContentRaw().equals("!info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("🖖 Information");
            info.setDescription("Bot para chat e moderação de servidor");
            info.addField("Creator", "Gabriel Lucas", false);
            info.addField("Github", "https://github.com/Gabriel-dev2", false);
            info.setColor(0xf45642);

            MessageChannel channel = event.getChannel();
            channel.sendMessageEmbeds(info.build()).queue();
        }

        if (msg.getContentRaw().equals("!today")) {
            MessageChannel channel = event.getChannel();
            LocalDateTime today = LocalDateTime.now();
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss");
            String formattedDate = formatDate.format(today);
            channel.sendMessage("📆​ It's " + formattedDate + " !").queue();
        }

        if (msg.getContentRaw().equals("!help")) {
            EmbedBuilder help = new EmbedBuilder();
            help.setTitle("💬 Help!");
            help.addField("Ping Pong", "!ping", false);
            help.addField("Current Time", "!hours", false);
            help.addField("Informations", "!info", false);
            help.addField("Current Day", "!today", false);

            MessageChannel channel = event.getChannel();
            channel.sendMessageEmbeds(help.build()).queue();
        }


    }

    @Override
    public void createListener(JDA jda) throws LoginException {
        // jda.addEventListener(new BotServiceImpl());
        // jda.setsetActivity(Activity.playing("Type !ping"))
        // .build();
    }
    
}
