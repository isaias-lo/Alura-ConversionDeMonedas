package com.alura.main.principal;


import com.alura.main.configuration.GsonMoneda;
import com.alura.main.configuration.HttpPedido;
import com.alura.main.moneda.Moneda;

import java.io.IOException;
import java.util.Scanner;

public class Menu  {
    private Scanner scanner = new Scanner(System.in);

    public void menu() throws IOException, InterruptedException {

        HttpPedido pedido = new HttpPedido("d5a833ab8920dcc05e60389c");
        GsonMoneda gsonMoneda = new GsonMoneda();

        Moneda moneda = new Moneda();

        boolean opcionModo =true;

        String texto = """
                *****************************************************
                Sea bienvenido/a al Conversor de Moneda =)
                
                1) Dolar =>> Peso Argentino
                2) Peso Argentino =>> Dolar
                3) Dolar =>> Real brasileño
                4) Real brasileño =>> Dolar
                5) Dolar =>> Peso colombiano
                6) Peso colombiano =>> Dolar
                7) Salir
                Elija una opcion valida:
                *****************************************************
                """;

        while (opcionModo){
            System.out.println(texto);
            int opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    double money = moneda.getAmount();
                    String json = pedido.makeCall("USD","ARS", money);
                    gsonMoneda.conexionGson(json, money);
                    break;
                case 2:
                    double money1 = moneda.getAmount();
                    String json1 = pedido.makeCall("ARS","USD", money1);
                    gsonMoneda.conexionGson(json1, money1);
                    break;
                case 3:
                    double money2 = moneda.getAmount();
                    String json2 = pedido.makeCall("USD","BRL", money2);
                    gsonMoneda.conexionGson(json2, money2);
                    break;
                case 4:
                    double money3 = moneda.getAmount();
                    String json3 = pedido.makeCall("BRL","USD", money3);
                    gsonMoneda.conexionGson(json3, money3);
                    break;
                case 5:
                    double money4 = moneda.getAmount();
                    String json4 = pedido.makeCall("USD","COP", money4);
                    gsonMoneda.conexionGson(json4, money4);
                    break;
                case 6:
                    double money5 = moneda.getAmount();
                    String json5 = pedido.makeCall("COP","USD", money5);
                    gsonMoneda.conexionGson(json5, money5);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    opcionModo = false;
                    break;

            }
        }
    }
}
