package com.thoughtworks.xbyi.persona.application.restful;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeEndPoint {
    @GetMapping("/")
    Map<String, String> home() {
        Map message = new HashMap<String, String>();
        message.put("name", "Persona");
        return message;
    }
}
