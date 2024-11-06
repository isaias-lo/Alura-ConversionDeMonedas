package com.alura.main;

import com.alura.main.moneda.Moneda;
import com.alura.main.moneda.MonedaRecord;
import com.alura.main.pelicula.Pelicula;
import com.alura.main.pelicula.PeliculaOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la cantidad: ");
        String cantidad = scanner.nextLine();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/d5a833ab8920dcc05e60389c/pair/USD/CLP/"+cantidad)).build();

        HttpResponse<String> responde = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = responde.body();
        System.out.println(json);


        //Configuracion de Gson
        Gson gson = new GsonBuilder()
                .create();


        MonedaRecord monedaRecord = gson.fromJson(json, MonedaRecord.class);
        System.out.println(monedaRecord);

        Moneda moneda = new Moneda(monedaRecord);
        System.out.println(moneda);
    }
}
