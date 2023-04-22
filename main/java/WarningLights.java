/* 
COP 3530 PROJECT
WARNING LIGHT FEATURE
CONTRIBUTOR NICOLAS RODRIGUEZ
*/


import java.util.BitSet;

public class WarningLights implements FuelGaugeInterface, TemperatureGaugeInterface {

    private BitSet warningBits;

    public WarningLights() {
        warningBits = new BitSet(5); // 5 bits for the five warning lights, each bit correlates to a light
    }

    public void setEngineLightOn(boolean on) {
        warningBits.set(0, on);
    }

    public void setOilLightOn(boolean on) {
        warningBits.set(1, on);
    }

    public void setTirePressureLightOn(boolean on) {
        warningBits.set(2, on);
    }

    public void setTemperatureLightOn(boolean on) {
        warningBits.set(3, on);
    }

    public boolean isEngineLightOn() {
        if (warningBits.get(0)) {
            System.out.println("Engine warning: Check engine!");
        }
        return warningBits.get(0);
    }

    public boolean isOilLightOn() {
        if (warningBits.get(1)) {
            System.out.println("Oil warning: Check oil levels!");
        }
        return warningBits.get(1);
    }

    public boolean isFuelLightOn(int gallons) {
        if (isLowFuel(gallons)) {
            warningBits.set(2, true);
            System.out.println("Low fuel warning!");
        } else {
            warningBits.set(2, false);
        }
        return warningBits.get(2);
    }

    public boolean isTemperatureLighton(int currentTemp) {
        if (isOverheated(currentTemp)) {
            warningBits.set(3, true);
            currentTemp(currentTemp);
            displayOverheated();
        } else {
            warningBits.set(3, false);
        }
        return warningBits.get(3);
    }

    public int getMiles(int miles) {
        return miles / 2;
    }

    public int getFuel(int gallons) {
        return gallons;
    }

    public boolean isLowFuel(int gallons) {
        int threshold = 2;
        return (gallons < threshold);
    }

    public int getTemp(int temp) {
        return temp;
    }

    public void currentTemp(int temp) {
        System.out.println("Current temperature: " + temp + "F");
    }

    public boolean isOverheated(int temp) {
        return temp > 220;
    }

    public void displayOverheated() {
        System.out.println("Temperature warning: Overheated!");
    }
}
