
package com.example.ai_assistant.controller;

import com.example.ai_assistant.service.OllamaService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ai")
public class ChatController {

    private final OllamaService ollamaService;

    public ChatController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/chat")
    public Map<String, String> chat(
            @RequestBody Map<String, String> request) {

        String question = request.get("question");

        String answer = ollamaService.generateAnswer(question);

        return Map.of("answer", answer);
    }
}
