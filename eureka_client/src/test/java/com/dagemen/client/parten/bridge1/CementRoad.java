package com.dagemen.client.parten.bridge1;

import com.dagemen.client.parten.bridge.Road;
import com.dagemen.client.parten.bridge.Vehicle;

public class CementRoad extends Road {

    public CementRoad(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void driveOnRoad() {
        super.vehicle.drive();
        System.out.println("行驶在水泥路");
    }
}
