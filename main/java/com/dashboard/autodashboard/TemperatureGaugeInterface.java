package com.dashboard.autodashboard;
/* 
COP 3530 PROJECT
TEMPERATURE INTERFACE
CONTRIBUTOR NICOLAS RODRIGUEZ
*/

public interface TemperatureGaugeInterface {
    // implementation for temperature gauge methods
    int getTemp(int temp);
    void currentTemp(int temp);
    boolean isOverheated(int temp);
    void displayOverheated();
}
