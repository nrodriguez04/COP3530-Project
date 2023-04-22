/* 
COP 3530 PROJECT
FUEL GAUGE FEATURE
CONTRIBUTOR LORENZO FERNANDEZ
*/

import java.util.Scanner;
import java.util.Stack;

import javax.lang.model.util.ElementScanner14;
import javax.swing.event.SwingPropertyChangeSupport;

public class FuelGauge extends Odometer {

    Scanner scanner = new Scanner(System.in);
    FuelGauge fuelGauge = new FuelGauge();
    int miles = fuelGauge.getMiles(0, scanner); // miles driven
    private int maxMiles = 250; // maximum amount of miles per full tank of gas of avg automobile
    private int gallons; // gallons of fuel
    private int MPG; // average miles per gallon
    private int fullTank = 12; // full tank of fuel for an average automobile
    private int totalMPG = 0;

    Stack<Integer> trip = new Stack<Integer>();

    public int getMiles(int miles, Scanner scanner) {
        System.out.println("Enter the number of miles driven since last fill up: ");
        miles = scanner.nextInt();
        if (miles < 0) {
            System.out.println("Invalid input. Please re-enter miles.");
        } else if (miles >= 1 && miles <= maxMiles) {
            return miles;
        } else if (miles > maxMiles) {
            System.out.println(
                    "Invalid input. Vehicle unable to surpass maximum miles in single trip. Please re-enter miles.");
        }
        return miles;
    }

    public int getFuel(int gallons) { // get the current fuel of the vehicle (total gallon minus gallon utilized)
        gallons = fullTank - gallons;

        return gallons;
    }

    public boolean isLowFuel(int gallons) {
        int threshold = 2; // set low fuel threshold to 2 gallons
        return (gallons < threshold);
    }

    public void displayFuel() { // display the vehicle's current fuel
        System.out.println("Vehicle's current fuel: " + getFuel(MPG));
    }

    public int getMPG(int miles, int gallons) {
        Scanner inputScanner = new Scanner(System.in);
        miles = getMiles(miles, inputScanner);
        gallons = getFuel(gallons);
        inputScanner.close();
        MPG = miles / gallons;
        return MPG;
    }

    public int MPGCalculator(int MPG) {
        Scanner tripScanner = new Scanner(System.in);
        System.out.println("Enter the amount of trips taken: ");
        int trips = tripScanner.nextInt();
        for (int i = 0; i < trips; i++) {
            MPG = getMPG(miles, gallons);
            trip.push(MPG);
        }
        while (!trip.isEmpty()) { // Stack to obtain total miles per gallon
            totalMPG += trip.pop();
        }
        tripScanner.close();
        return totalMPG;
    }

    public void displayMPG() {
        System.out.println("Vehicle's MPG: " + MPGCalculator(MPG));
    }

}
