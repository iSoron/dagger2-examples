package com.example;

import javax.inject.*;
import com.acme.*;

public class LocationManager {

    private final GpsSensor gps;

    @Inject
    public LocationManager(GpsSensor gps) {
        this.gps = gps;
    }
}
