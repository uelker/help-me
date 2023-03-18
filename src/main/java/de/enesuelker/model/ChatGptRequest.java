package de.enesuelker.model;

public record ChatGptRequest(String model, String prompt, int temperature, int max_tokens) {
}
