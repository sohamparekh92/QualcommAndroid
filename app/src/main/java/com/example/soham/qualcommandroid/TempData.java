package com.example.soham.qualcommandroid;

/**
 * Created by Soham on 10/4/2016.
 */

public class TempData {

    private int celsius;
    private String day;

    public TempData(String day, int celsius) {
        this.day = day;
        this.celsius = celsius;
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
