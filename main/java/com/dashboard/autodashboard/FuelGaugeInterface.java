package com.dashboard.autodashboard;
/* 
COP 3530 PROJECT
FUEL GAUGE INTERFACE
CONTRIBUTOR NICOLAS RODRIGUEZ
*/

public interface FuelGaugeInterface {
    // implementation for fuel gauge methods
    int getMiles(int miles);
    int getFuel(int gallons);
    boolean isLowFuel(int gallons);
}
