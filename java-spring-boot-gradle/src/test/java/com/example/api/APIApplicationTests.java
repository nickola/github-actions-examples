// Package
package com.example.api.controller;

// Tests
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class APIApplicationTests {
    @Test
    void testGreetings() {
        MainResource resource = new MainResource();
        String greetings = resource.getGreetings();

        assertEquals(greetings, "Hello world!");
    }
}
