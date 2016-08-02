package com.example;
import dagger.*;

@Module
public class WeatherChannelModule {
    @Provides
    WeatherService provideWeatherService() {
        return new WeatherChannel();
    }
}
