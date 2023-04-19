/* 
COP 3530 PROJECT
AUTOMOBILE DASHBOARD
CONTRIBUTORS: 
NICOLAS RODRIGUEZ: ODOMETER, WARNING LIGHTS, NAVIGATION
AJ CARDOZA: ENTERTAINMENT SYSTEM, DRIVING ASSIST, AUTOMATIC HEADLIGHTS
LORENZO FERNANDEZ: SPEEDOMETER, FUEL GAUGE, TEMPERATURE GAUGE
*/

public class main {
    public static void main(String[] args) {

        // Access Entertainment System
        Entertainment.main(args);
        // Access DrivingAssist
        DrivingAssist.main(args);
        // Access Headlights
        Headlights.main(args);

        TemperatureGauge temp = new TemperatureGauge();
        temp.displayTemp();

        Speedometer speed = new Speedometer();
        speed.displaySpeed();
        speed.speedWarning();
        speed.displayAverageSpeed();

        FuelGauge fuel = new FuelGauge();
        fuel.displayFuel();
        fuel.displayMPG();

        // Create objects of required classes
        Odometer odometer = new Odometer();
        Navigation navigation = new Navigation();
        WarningLights warningLights = new WarningLights();

        // Access Odometer
        odometer.currentDistance(200);
        // Access Navigation
        navigation.setDestination("FIU");
        // Access Warning Lights
        warningLights.setTemperatureLightOn(true);
    }
}