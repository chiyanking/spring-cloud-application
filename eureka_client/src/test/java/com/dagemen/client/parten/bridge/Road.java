package com.dagemen.client.parten.bridge;

public abstract class Road {

    protected Vehicle vehicle;

    public Road(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract void driveOnRoad();

}
