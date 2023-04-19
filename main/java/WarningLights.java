/* 
COP 3530 PROJECT
WARNING LIGHT FEATURE
CONTRIBUTOR NICOLAS RODRIGUEZ
*/

import java.util.BitSet;

public class WarningLights extends TemperatureGauge {

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

    public boolean isTirePressureLightOn() {
        if (warningBits.get(2)) {
            System.out.println("Tire pressure warning: Check tire pressure!");
        }
        return warningBits.get(2);
    }

    public boolean isTemperatureLighton(int temp) {
        if (isOverheated(temp)) {
            warningBits.set(3, true);
            displayOverheated(temp);
        } else {
            warningBits.set(3, false);
        }
        return warningBits.get(3);
    }
}