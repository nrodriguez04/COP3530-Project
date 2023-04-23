package com.dashboard.autodashboard;
/* 
COP 3530 PROJECT
SPEEDOMETER FEATURE
CONTRIBUTOR LORENZO FERNANDEZ
*/


public class Speedometer implements OdometerInterface {

    int speed;
    int maxSpeed = 120; // max speed of an average automobile in miles per hour
    int minSpeed = 0; // min speed of an average automobile in miles per hour
    int speedRange = maxSpeed - minSpeed; // range of speed of an average automobile in miles per hour
    boolean speedWarning = false;
    int setSpeed = (int) (Math.random() * speedRange + minSpeed);

    int[] speedArray = new int[10]; // speed array for binary tree search based on 10 recored speeds

    Speedometer speedometer = new Speedometer();

    public int getSpeed(int speed) {
        setSpeed = (int) (Math.random() * speedRange + minSpeed);
        return setSpeed;
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
            speedArray[i] = getSpeed(speed);
            speed += speedArray[i];
            // System.out.println("Speed: " + speedArray[i] + "mph"); // Tests to display
            // all
            // speeds recored in trip
        }
        return speed / speedArray.length;
    }

    public void displayAverageSpeed() {
        System.out.println("Average speed: " + getAverageSpeed() + "mph");
    }

    public int getCurrentDistance() {
        int currentDistance = 0;
        return currentDistance;
    }

    public int avgSpeedPerMile(int getAverageSpeed, int getCurrentDistance) {
        int avgSpeedPerMile = getAverageSpeed() / getCurrentDistance();
        return avgSpeedPerMile;
    }

    public void displayAvgSpeedPerMile() {
        System.out
                .println("Average speed per mile: " + avgSpeedPerMile(getAverageSpeed(), getCurrentDistance()) + "mph");
    }
}