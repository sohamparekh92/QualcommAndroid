package com.example.soham.qualcommandroid;

/**
 * Created by Soham on 10/4/2016.
 */

public class TempData {

    private int celsius;
    private int fahrenheit;
    private String day;

    public TempData(String day, int celsius) {
        this.day = day;
        this.celsius = celsius;
        this.fahrenheit = 0; //Fahrenheit value initialized to 0 as it will be set after
                             //the conversion by the native method
    }

    public int getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(int fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getCelsius() {
        return celsius;
    }

    public void setCelsius(int celsius) {
        this.celsius = celsius;
    }
}
