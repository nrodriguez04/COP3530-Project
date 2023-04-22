/* 
COP 3530 PROJECT
SPEEDOMETER FEATURE
CONTRIBUTOR LORENZO FERNANDEZ
*/


public class Speedometer {

    int speed;
    int maxSpeed = 120; // max speed of an average automobile in miles per hour
    int minSpeed = 0; // min speed of an average automobile in miles per hour
    int speedRange = maxSpeed - minSpeed; // range of speed of an average automobile in miles per hour
    boolean speedWarning = false;
    int setSpeed = (int) (Math.random() * speedRange + minSpeed);

    int[] speedArray = new int[10]; // speed array for binary tree search

    public int getSpeed(int speed) {
        setSpeed = (int) (Math.random() * speedRange + minSpeed);
        return speed;
    }

    public void displaySpeed() {
        System.out.println("Vehicle's current speed: " + setSpeed + "mph");
    }

    public void displaySpeedWarningLimit() {
        System.out.println("Vehicle is speeding over limit: " + setSpeed + "mph");
    }

    public void speedWarning() {
        if (setSpeed > 80) {
            displaySpeedWarningLimit();
        } else {
            System.out.println("Vehicle is within driving limits.");
        }
    }

    // binary tree search for average speed

    public int getAverageSpeed() {

        for (int i = 0; i < speedArray.length; i++) {
            setSpeed += speedArray[i];
        }
        return (int) setSpeed / speedArray.length;
    }

    public void displayAverageSpeed() {
        System.out.println("Average speed: " + getAverageSpeed() + "mph");
    }

}