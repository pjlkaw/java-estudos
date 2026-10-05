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
        JsonNode data = objectMapper.readTree(response.body());
        ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
        String jsonFormatado = writer.writeValueAsString(data);
        System.out.println(jsonFormatado);

        for (int i = 0; i < data.size(); i++) {
            System.out.println("Repositório: " + data.get(i).get("repo").get("name"));
            System.out.println("Eventos encontrados: " + data.size()); 
            System.out.println("Usuário: " + data.get(i).get("actor").get("login")); 
            System.out.println("ID: " + data.get(i).get("id")); 
            System.out.println("Data: " + data.get(i).get("created_at")); 
            System.out.println("-------------------------\n");
        }
    }

}