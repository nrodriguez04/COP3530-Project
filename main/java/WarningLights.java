import java.util.BitSet;

public class WarningLights {

    private BitSet warningBits;

    public WarningLights() {
        warningBits = new BitSet(3); // 3 bits for the three warning lights
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

    public boolean isEngineLightOn() {
        if (engineLightOn) {
            System.out.println("Engine warning: Check engine!");
        }
        return engineLightOn;
    }
    
    public boolean isOilLightOn() {
        if (oilLightOn) {
            System.out.println("Oil warning: Check oil levels!");
        }
        return oilLightOn;
    }
    
    public boolean isTirePressureLightOn() {
        if (tirePressureLightOn) {
            System.out.println("Tire pressure warning: Check tire pressure!");
        }
        return tirePressureLightOn;
    }
}