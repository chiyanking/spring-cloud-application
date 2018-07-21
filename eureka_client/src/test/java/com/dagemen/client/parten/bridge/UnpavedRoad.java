package com.dagemen.client.parten.bridge;

public class UnpavedRoad extends Road {

    public UnpavedRoad(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void driveOnRoad() {
        super.vehicle.drive();
        System.out.println("行驶在石子路");
    }
}
