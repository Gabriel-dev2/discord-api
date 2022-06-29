package com.discord.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MessageTest {
    
    @Test
    public void message_test_default_constructor() throws Exception {
        Message message = new Message();

        message.setChannelName("conversa");
        assertEquals("conversa", message.getChannelName());

        message.setMessage("Huehuehue");
        assertEquals("Huehuehue", message.getMessage());

    }
}
