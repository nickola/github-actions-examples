// Package
package com.example.api.controller;

// Spring Framework
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.MediaType;

// REST
@RestController
@RequestMapping("/")
public class MainResource {
    public String getGreetings() {
        return "Hello world!";
    }

    @GetMapping(value="/", produces=MediaType.APPLICATION_JSON_VALUE)
    public String home() {
        String greetings = getGreetings();
        return "{\"text\": \"" + greetings + "\"}";
    }
}
