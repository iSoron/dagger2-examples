package com.example;
import com.acme.*;
import dagger.*;

@Module
public class GpsSensorModule {
    @Provides
    GpsSensor provideGpsSensor() {
        GpsSensor gps = new GpsSensor();
        gps.calibrate();
        return gps;
    }
}
