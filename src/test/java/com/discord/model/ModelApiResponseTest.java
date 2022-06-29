package com.discord.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ModelApiResponseTest {
    
    @Test
    public void modelApiResponse_testing_default_constructor() throws Exception {
        ModelApiResponse test = new ModelApiResponse();

        test.setCode(200);
        assertTrue(200 == test.getCode());

        test.setMessage("Mensagem enviada com sucesso!");
        assertEquals("Mensagem enviada com sucesso!", test.getMessage());
    }
}
