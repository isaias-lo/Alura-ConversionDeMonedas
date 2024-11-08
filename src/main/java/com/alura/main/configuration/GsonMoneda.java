package com.alura.main.configuration;

import com.alura.main.moneda.Moneda;
import com.alura.main.moneda.MonedaRecord;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonMoneda {


    public void conexionGson(String json, double moneda){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        MonedaRecord monedaRecord = gson.fromJson(json, MonedaRecord.class);

        Moneda mon = new Moneda(monedaRecord, moneda);

        System.out.println(mon);
        System.out.println(" ");
    }
}
