package com.bobocode.petros.propositionservice.domain.dto.enumeration;

import java.util.concurrent.ThreadLocalRandom;

public enum FlightClass {
    FIRST,
    BUSINESS,
    ECONOMY;

    public static FlightClass getRandomFlightClass() {
        return values()[ThreadLocalRandom.current().nextInt(values().length)];
    }
}
