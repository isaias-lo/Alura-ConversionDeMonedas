package com.alura.main.configuration;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class HttpPedido {

    private Scanner scanner = new Scanner(System.in);
    private String key;

    public HttpPedido(String key){
        this.key = key;
    }

    public String makeCall(String localMoney, String finalMoney, double amount) throws IOException, InterruptedException {


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/"+key+"/pair/"+localMoney+"/"+finalMoney+"/"+String.valueOf(amount))).build();

        HttpResponse<String> responde = client.send(request, HttpResponse.BodyHandlers.ofString());


        return responde.body();
    }
}
