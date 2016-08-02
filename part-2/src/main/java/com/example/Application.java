package com.example;

import javax.inject.*;
import dagger.*;
import com.acme.*;

@Module
class YahooWeatherModule {

    private final String key;

    public YahooWeatherModule(String key) {
        this.key = key;
    }

    @Provides
    WeatherService provideWeatherService(WebSocket socket) {
        return new YahooWeather(key, socket);
    }
}

@Module
class WeatherChannelModule {
    @Provides
    WeatherService provideWeatherService() {
        return new WeatherChannel();
    }
}

@Module
class GpsSensorModule {
    @Provides
    GpsSensor provideGpsSensor() {
        GpsSensor gps = new GpsSensor();
        gps.calibrate();
        return gps;
    }
}

@Component(modules = {YahooWeatherModule.class, GpsSensorModule.class})
interface AppComponent {
    WeatherReporter getWeatherReporter();
}

public class Application {
    public static void main(String args[]) {
        String apiKey = args[0];
        YahooWeatherModule yahoo = new YahooWeatherModule(apiKey);
        AppComponent component = DaggerAppComponent.builder()
               .yahooWeatherModule(yahoo)
               .build();
        WeatherReporter reporter = component.getWeatherReporter();
        reporter.report();
    }
}
