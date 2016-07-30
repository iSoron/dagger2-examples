package com.example;
import javax.inject.*;

public class LocationManager {

    private final Logger logger;

    private final GPSProvider gpsProvider;

    @Inject
    public LocationManager(Logger logger, GPSProvider gpsProvider) {
        this.logger = logger;
        this.gpsProvider = gpsProvider;
    }
}
