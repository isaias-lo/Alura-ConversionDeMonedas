package com.alura.main.moneda;

import com.google.gson.annotations.SerializedName;

import java.util.Scanner;

public class Moneda {

    private String codeBase;

    private String targetBase;

    private double conversionResult;

    private double amount;

    private Scanner scanner = new Scanner(System.in);

    public Moneda(){

    }
    public Moneda(MonedaRecord monedaRecord, double amount){
        this.codeBase = monedaRecord.base_code();
        this.targetBase = monedaRecord.target_code();
        this.conversionResult = Double.valueOf(monedaRecord.conversion_result());
        this.amount = amount;
    }

    public String getTargetBase() {
        return targetBase;
    }

    public void setTargetBase(String targetBase) {
        this.targetBase = targetBase;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(double conversionResult) {
        this.conversionResult = conversionResult;
    }

    public String getCodeBase() {
        return codeBase;
    }

    public void setCodeBase(String codeBase) {
        this.codeBase = codeBase;
    }


    public double getAmount(){
        System.out.println("Ingrese el valor que deseas convertir: ");
        return scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "El valor "+amount+"["+codeBase+"] "+"corresponde al valor final de =>>> "+conversionResult+" ["+targetBase+"]";
    }
}
