package com.discord.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
@ConfigurationProperties
public class DiscordConfig {
    
    @Value("${discord.token}")
    private String discordToken;
}
