import java.util.Scanner;

public class Speedometer {

    int speed; // speed of an average automobile in miles per hour
    int maxSpeed = 120; // max speed of an average automobile in miles per hour
    int minSpeed = 0; // min speed of an average automobile in miles per hour
    int speedRange = maxSpeed - minSpeed; // range of speed of an average automobile in miles per hour
    boolean speedWarning = false;

    public void displaySpeed() {
        System.out.println("Vehicle's current speed: " + getSpeed(speed));
    }

    public boolean isSpeedWarning(int speed) {
        if (speed > 80) {
            return true;
        } else {
            return false;
        }
    }

    public int getSpeed(int speed) {
        Scanner speedScanner = new Scanner(System.in);
        System.out.println("Enter the vehicle's current speed: ");
        speed = speedScanner.nextInt();
        if (speed < 0) {
            System.out.println("Invalid input. Please re-enter speed.");
        } else if (speed >= 1 && speed <= maxSpeed) {
            return speed;
        } else if (speed > maxSpeed) {
            System.out.println("Invalid input. Vehicle unable to surpass maximum speed. Please re-enter speed.");
        }
        return speed;
    }
}