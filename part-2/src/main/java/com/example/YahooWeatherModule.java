package com.example;
import dagger.*;

@Module
public class YahooWeatherModule {

    private final String key;

    public YahooWeatherModule(String key) {
        this.key = key;
    }

    @Provides
    WeatherService provideWeatherService(WebSocket socket) {
        return new YahooWeather(key, socket);
    }
}

