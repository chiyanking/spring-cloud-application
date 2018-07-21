package com.dagemen.client.parten.bridge;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoadTest {

    @Test
    public void driveOnRoad() {
        Vehicle bus = new Bus();


        CementRoad cementRoad = new CementRoad(bus);


        cementRoad.driveOnRoad();

    }
}