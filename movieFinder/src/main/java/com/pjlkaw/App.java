package com.pjlkaw;
import java.io.IOException; //Pode gerar algum tipo de erro
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.ObjectMapper; // mapear o JSON

public class App {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request
            .Builder()
            .url("https://api.tvmaze.com/search/shows?q=girls")
            .build();

        Response response = client.newCall(request).execute();
        
        String json = response.body().string();

        ObjectMapper mapper = new ObjectMapper();
        var data = mapper.readTree(json);
        System.out.println(data.get(0).get("show").get("name").asText());
        
    }
}
