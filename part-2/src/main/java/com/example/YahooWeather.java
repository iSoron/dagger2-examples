package com.example;
import javax.inject.Inject;

public class YahooWeather implements WeatherService {

    private final WebSocket socket;

    private final String key;

    public YahooWeather(String key, WebSocket socket) {
        this.key = key;
        this.socket = socket;
    }
}
