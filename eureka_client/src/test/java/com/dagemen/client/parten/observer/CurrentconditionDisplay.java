package com.dagemen.client.parten.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentconditionDisplay implements Observer, DisplayElement {


    Observable observable;
    private float temperature;
    private float humidity;


    public CurrentconditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("this temperature" + this.temperature + " humidity: " + humidity);
    }
}
