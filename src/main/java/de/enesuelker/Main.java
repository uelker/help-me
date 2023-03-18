package de.enesuelker;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.enesuelker.model.ChatGptRequest;
import de.enesuelker.model.ChatGptResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    private static final String API_KEY = "<YOUR_API_KEY>";
    private static final String MESSAGE = "Help me by:";

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print(MESSAGE);

        String promt = MESSAGE + scanner.nextLine();

        ObjectMapper objectMapper = new ObjectMapper();
        ChatGptRequest chatGptrequest = new ChatGptRequest("text-davinci-003", promt, 0, 100);
        String input = objectMapper.writeValueAsString(chatGptrequest);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/completions"))
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(input))
                .build();
        HttpClient client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            ChatGptResponse chatGptResponse = objectMapper.readValue(response.body(), ChatGptResponse.class);
            String answer = chatGptResponse.choices()[0].text();

            if (!answer.isEmpty()) {
                System.out.println(answer.replace("\n", ""));
            }
        }
    }
}
