package com.analumarcal.weatherapi.service;

import com.analumarcal.weatherapi.model.WeatherResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WeatherResponse getWeatherByCity(String city) {
        String url = String.format("%s?q=%s&appid=%s&units=metric", apiUrl, city, apiKey);
        String response = restTemplate.getForObject(url, String.class);

        try {
            JsonNode json = objectMapper.readTree(response);
            String cityName = json.get("name").asText();
            double temperature = json.get("main").get("temp").asDouble();
            String description = json.get("weather").get(0).get("description").asText();
            double humidity = json.get("main").get("humidity").asDouble();

            return new WeatherResponse(cityName, temperature, description, humidity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
