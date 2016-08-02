package com.example;
import javax.inject.*;

public class WeatherReporter {

    private final WeatherService weatherService;

    private final LocationManager locationManager;

    @Inject
    public WeatherReporter(WeatherService weatherService,
                           LocationManager locationManager) {
        this.locationManager = locationManager;
        this.weatherService = weatherService;
    }

    public void report() {
        // locationManager.getCurrentLocation()
        // weatherService.getConditionsAt(currentLocation)
        System.out.println("Mostly clouded, 26 C\n");
    }
}
