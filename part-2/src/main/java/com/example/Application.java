package com.example;
import javax.inject.*;
import dagger.*;
import com.acme.*;

@Component(modules = {YahooWeatherModule.class, GpsSensorModule.class})
interface AppComponent {
    WeatherReporter getWeatherReporter();
}

public class Application {
    public static void main(String args[]) {
        if(args.length < 1) {
            System.out.println("You must provide an API key\n");
            return;
        }

        String apiKey = args[0];
        YahooWeatherModule yahoo = new YahooWeatherModule(apiKey);

        AppComponent component = DaggerAppComponent.builder()
               .yahooWeatherModule(yahoo)
               .build();
        WeatherReporter reporter = component.getWeatherReporter();
        reporter.report();
    }
}
