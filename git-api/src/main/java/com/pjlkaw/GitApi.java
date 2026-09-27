package com.pjlkaw;

import java.net.URI; // URI = endereço da casa*
import java.net.http.HttpClient;// HttpRequest = carta que você vai enviar*
import java.net.http.HttpRequest; // HttpRequest = carta que você vai enviar*
import java.net.http.HttpResponse; // HttpResponse = resposta recebidas*

import com.fasterxml.jackson.databind.*;

public class GitApi {

public static void main(String[] args) throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        String account = "pjlkaw";

        String url = "https://api.github.com/users/" + account + "/events";

        HttpRequest request = HttpRequest
            .newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
        
        JsonNode data = objectMapper.readTree(response.body());
        String jsonFormatado = writer.writeValueAsString(data);
        System.out.println(jsonFormatado);

        System.out.println(data.get(0).get("actor").get("login"));
    }

}