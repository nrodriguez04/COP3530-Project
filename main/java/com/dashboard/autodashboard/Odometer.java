package com.dashboard.autodashboard;
/* 
COP 3530 PROJECT
ODOMETER FEATURE
CONTRIBUTOR NICOLAS RODRIGUEZ
*/

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Odometer implements OdometerInterface {
    private int currentDistance;
    private int prevDistance;
    private File dataFile;
    
    public Odometer() {
        currentDistance = 0;
        prevDistance = 0;
        dataFile = new File("odometer.txt");
        try {
            if (dataFile.createNewFile()) {
                // File is newly created, initialize with 0 distance
                writeDataToFile(0);
            } else {
                // File already exists, read previous distance
                prevDistance = readDataFromFile();
                currentDistance = prevDistance;
            }
        } catch (IOException e) {
            System.out.println("Failed to create odometer data file.");
        }
    }
    
    public void incrementDistance(int distance) {
        currentDistance += distance;
        writeDataToFile(currentDistance);
    }

    public void incrementDistance() {
        incrementDistance(1);
    }
    
    @Override
    public int getCurrentDistance() {
        return currentDistance;
    }
    
    private void writeDataToFile(int distance) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dataFile))) {
            writer.println(distance);
        } catch (IOException e) {
            System.out.println("Failed to write odometer data to file.");
        }
    }
    
    private int readDataFromFile() {
        try (Scanner scanner = new Scanner(dataFile)) {
            return scanner.nextInt();
        } catch (IOException e) {
            System.out.println("Failed to read odometer data from file.");
        }
        return 0;
    }
    
    public void correctError(int expectedDistance) {
        if (currentDistance != expectedDistance) {
            System.out.println("Odometer error detected, correcting distance.");
            currentDistance = expectedDistance;
            writeDataToFile(currentDistance);
        }
    }

     public int getTotalDistance() {
        int totalMileage = 0;
        Stack<Integer> totalDistance = new Stack<Integer>();
        totalDistance.push(currentDistance);
        System.out.println("Total distance traveled: " + totalDistance.pop() + " miles.");
        while (!totalDistance.isEmpty()) {
            totalMileage += totalDistance.pop();
        }
        return totalMileage;
    }
}
