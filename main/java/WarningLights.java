public class WarningLights {

    private boolean engineLightOn;
    private boolean oilLightOn;
    private boolean tirePressureLightOn;

    public WarningLights() {
        engineLightOn = false;
        oilLightOn = false;
        tirePressureLightOn = false;
    }

    public void setEngineLightOn(boolean on) {
        engineLightOn = on;
    }

    public void setOilLightOn(boolean on) {
        oilLightOn = on;
    }

    public void setTirePressureLightOn(boolean on) {
        tirePressureLightOn = on;
    }

    public boolean isEngineLightOn() {
        return engineLightOn;
    }

    public boolean isOilLightOn() {
        return oilLightOn;
    }

    public boolean isTirePressureLightOn() {
        return tirePressureLightOn;
    }
}