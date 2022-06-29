package com.discord.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.security.auth.login.LoginException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.discord.configuration.DiscordConfig;
import com.discord.services.impl.BotServiceImpl;

@RunWith(SpringRunner.class)
public class BotServiceTest {

    @Mock
    private DiscordConfig discordConfig;
    
    @InjectMocks
    private BotServiceImpl service;

    String channel = "conversa";
    String message = "Mensagem do dia";

    @Before
    public void setUp() throws Exception {
        when(this.discordConfig.getDiscordToken()).thenReturn(System.getenv("DISCORD_TOKEN"));
    }

    @Test
    public void sendMessage_testing_with_valid_channel() throws LoginException, InterruptedException {
        boolean expected = true;

        boolean result = this.service.sendMessage(channel, message);

        assertEquals(expected, result);
    }
}
