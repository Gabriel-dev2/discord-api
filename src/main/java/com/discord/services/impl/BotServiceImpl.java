package com.discord.services.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discord.configuration.DiscordConfig;
import com.discord.services.BotService;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Service
public class BotServiceImpl extends ListenerAdapter implements BotService {

    @Autowired
    private DiscordConfig discordConfig;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        String strMessage = msg.getContentRaw();
        MessageChannel channel = event.getChannel();

        switch (strMessage) {
            case "!help":
                EmbedBuilder help = new EmbedBuilder();
                help.setTitle("💬 Help!");
                help.addField("Ping Pong", "!ping", false);
                help.addField("Current Time", "!hours", false);
                help.addField("Informations", "!info", false);
                help.addField("Current Day", "!today", false);

                channel.sendMessageEmbeds(help.build()).queue();
                break;

            case "!info":
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("🖖 Information");
                info.setDescription("Bot para chat e moderação de servidor");
                info.addField("Creator", "Gabriel Lucas", false);
                info.addField("Github", "https://github.com/Gabriel-dev2", false);
                info.setColor(0xf45642);

                channel.sendMessageEmbeds(info.build()).queue();
                break;

            case "!ping":
                channel.sendMessage("🏓 Pong!").queue();
                break;

            case "!hours":
                LocalTime now = LocalTime.now();
                channel.sendMessage("⌚ It's " + now + " !").queue();
                break;

            case "!today":
                LocalDateTime today = LocalDateTime.now();
                DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss");
                String formattedDate = formatDate.format(today);
                channel.sendMessage("📆​ It's " + formattedDate + " !").queue();
                break;

            default:
                if (strMessage.startsWith("!")) {
                    channel.sendMessage("​❌​ Invalid command, please try again or type **!help** to get some instructions.").queue();
                }
                break;
        }

    }

    @Override
    public boolean sendMessage(String channel, String message) throws LoginException, InterruptedException {
        JDABuilder jdaB = JDABuilder.createDefault(this.discordConfig.getDiscordToken());
        JDA jda = jdaB.build();
        jda.awaitReady();
        List<TextChannel> channels = jda.getTextChannelsByName(channel, false);
        TextChannel textChannel = channels.get(0);
        textChannel.sendMessage(message).queue();
        jda.shutdown();
        
        return true;
    }

}
