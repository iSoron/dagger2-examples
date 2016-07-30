package com.example;
import javax.inject.*;

public class WeatherService {

    private Logger logger;

    private WebSocket socket;

    @Inject
    public WeatherService(Logger logger, WebSocket socket) {
        this.logger = logger;
        this.socket = socket;
    }
}
