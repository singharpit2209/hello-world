package com.example;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class HandlerTest {
    @Test
    void returnsHelloMessage() {
        Handler handler = new Handler();
        var response = handler.handleRequest(Map.of(), null);
        assertEquals(200, response.get("statusCode"));
        assertEquals("{\"message\":\"Hello from Java Lambda\"}", response.get("body"));
    }
}
