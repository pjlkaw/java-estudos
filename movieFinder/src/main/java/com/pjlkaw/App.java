package com.pjlkaw;
import java.io.IOException; //Pode gerar algum tipo de erro
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class App {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request
            .Builder()
            .url("https://api.tvmaze.com/search/shows?q=girls")
            .build();

        Response response = client.newCall(request).execute();
        
        System.out.println(response.body().string());
    }
}
