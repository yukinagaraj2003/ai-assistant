
package com.example.ai_assistant.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class OllamaService {

    private final RestClient restClient =
            RestClient.create("http://localhost:11434");

    public String generateAnswer(String question) {

        Map<String, Object> request = Map.of(
                "model", "llama3.2",
                "prompt", question,
                "stream", false
        );

        Map response = restClient.post()
                .uri("/api/generate")
                .body(request)
                .retrieve()
                .body(Map.class);

        return (String) response.get("response");
    }
}
