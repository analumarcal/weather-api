package com.analumarcal.weatherapi.model;

public class WeatherResponse {
    private String city;
    private double temperature;
    private String description;
    private double humidity;

    public WeatherResponse(String city, double temperature, String description, double humidity) {
        this.city = city;
        this.temperature = temperature;
        this.description = description;
        this.humidity = humidity;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
