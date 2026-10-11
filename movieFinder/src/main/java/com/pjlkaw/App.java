package com.pjlkaw;
import java.io.IOException; //Pode gerar algum tipo de erro
import java.util.Scanner;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.ObjectMapper; // mapear o JSON

public class App {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Scanner S = new Scanner(System.in);
        System.out.print("Digite o nome de uma série: ");
        String search = S.nextLine();

        Request request = new Request
            .Builder()
            .url("https://api.tvmaze.com/search/shows?q="+search)
            .build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();
        ObjectMapper mapper = new ObjectMapper();

        
        
        var data = mapper.readTree(json);
        for (int i = 0; i<data.size(); i++) {
            String name = data.get(i).get("show").get("name").asText();
            String summary = data.get(i).get("show").get("summary").asText();
            String url = data.get(i).get("show").get("url").asText();
            
            Show show = new Show(name, summary, url);
            System.out.println(show.name);
            System.out.println(show.summary);
            System.out.println(show.url);
            System.out.println("---------------------------------------------------\n");
        }
        
    }
}


class Show {
    String name; 
    String summary; 
    String url; 
    
    public Show(String name, String summary, String url){
        this.name = name;
        this.summary = summary;
        this.url = url;
    }
}
