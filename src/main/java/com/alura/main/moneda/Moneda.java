package com.alura.main.moneda;

import com.google.gson.annotations.SerializedName;

public class Moneda {

    private String codeBase;

    private String targetBase;

    private double conversionResult;

    public Moneda(String codeBase, String targetBase, double conversionResult) {
        this.codeBase = codeBase;
        this.targetBase = targetBase;
        this.conversionResult = conversionResult;
    }

    public Moneda(MonedaRecord monedaRecord){
        this.codeBase = monedaRecord.base_code();
        this.targetBase = monedaRecord.target_code();
        this.conversionResult = Double.valueOf(monedaRecord.conversion_result());
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

    @Override
    public String toString() {
        return "Moneda{" +
                "codeBase='" + codeBase + '\'' +
                ", targetBase='" + targetBase + '\'' +
                ", conversionResult='" + conversionResult + '\'' +
                '}';
    }
}
