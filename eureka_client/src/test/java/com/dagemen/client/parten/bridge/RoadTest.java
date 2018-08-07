package com.dagemen.client.parten.bridge;

import com.dagemen.client.parten.bridge1.CementRoad;
import org.junit.Test;

public class RoadTest {

    @Test
    public void driveOnRoad() {
        Vehicle bus = new Bus();


        CementRoad cementRoad = new CementRoad(bus);


        cementRoad.driveOnRoad();

    }
}
