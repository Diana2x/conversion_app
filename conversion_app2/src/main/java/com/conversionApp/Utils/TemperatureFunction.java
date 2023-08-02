package com.conversionApp.Utils;



public class TemperatureFunction {
    private double temperatureConvertedValue;

    public TemperatureFunction(String tempFrom, String tempTo, double tempValue) {
        convertTemperature(tempFrom, tempTo, tempValue);
    }

    private void convertTemperature(String tempFrom, String tempTo, double tempValue) {
        if (tempFrom.equals("Celsius (°C)") && tempTo.equals("Fahrenheit (°F)")) {
            temperatureConvertedValue = (tempValue * 9 / 5) + 32;
        } else if (tempFrom.equals("Celsius (°C)") && tempTo.equals("Kelvin (K)")) {
            temperatureConvertedValue = tempValue + 273.15;
        } else if (tempFrom.equals("Fahrenheit (°F)") && tempTo.equals("Celsius (°C)")) {
            temperatureConvertedValue = (tempValue - 32) * 5 / 9;
        } else if (tempFrom.equals("Fahrenheit (°F)") && tempTo.equals("Kelvin (K)")) {
            temperatureConvertedValue = (tempValue + 459.67) * 5 / 9;
        } else if (tempFrom.equals("Kelvin (K)") && tempTo.equals("Celsius (°C)")) {
            temperatureConvertedValue = tempValue - 273.15;
        } else if (tempFrom.equals("Kelvin (K)") && tempTo.equals("Fahrenheit (°F)")) {
            temperatureConvertedValue = (tempValue * 9 / 5) - 459.67;
        } else {
            // If the conversion is not supported, set the value to 0 (or any other appropriate default value)
            temperatureConvertedValue = 0;
        }
    }

    public double getTemperatureConvertedValue() {
        return temperatureConvertedValue;
    }
}
