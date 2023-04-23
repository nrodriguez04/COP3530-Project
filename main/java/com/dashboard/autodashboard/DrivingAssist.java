package com.dashboard.autodashboard;
/* 
COP 3530 PROJECT
DRIVING ASSIST CAR FEATURE
CONTRIBUTOR AJ CARDOZA
*/

import java.util.PriorityQueue;
import java.util.Random;
import java.lang.reflect.Array;

public class DrivingAssist {

    private static class Car implements Comparable<Car> {
        private String name;
        private int speed;
        private int distance;
    
        public Car(String name, int speed, int distance) {
            this.name = name;
            this.speed = speed;
            this.distance = distance;
        }
    
        public String getName() {
            return name;
        }
    
        public int getSpeed() {
            return speed;
        }
    
        public int getDistance() {
            return distance;
        }
    
        @Override
        public int compareTo(Car other) {
            return Integer.compare(distance, other.distance);
        }
    }

    private static void activateDirectionalSignal(MyPriorityQueue<Car> carQueue, boolean blinkerEngaged) {
        if (blinkerEngaged) {
            if (carQueue.peekLeft() != null) {
                Car leftCar = carQueue.peekLeft();
                if (leftCar.getSpeed() > 0 && leftCar.getDistance() < 30 && leftCar.getDistance() > -30) {
                    System.out.println("Car on the left! Slow down!");
                }
            }
            if (carQueue.peekRight() != null) {
                Car rightCar = carQueue.peekRight();
                if (rightCar.getSpeed() > 0 && rightCar.getDistance() < 30 && rightCar.getDistance() > -30) {
                    System.out.println("Car on the right! Slow down!");
                }
            }
        }
        else {
            if (carQueue.peek() == null) {
                return;
            }

            Car car = carQueue.peek();
            if (car.getDistance() < 30 && car.getDistance() > -30) {
                System.out.println("Car ahead! Slow down!");
            }
        }
    }

    private static class MyPriorityQueue<T> extends PriorityQueue<T> {
        public T peekLeft() {
            if (size() == 0) {
                return null;
            }
            return get(size() - 1);
        }

        public T peekRight() {
            if (size() == 0) {
                return null;
            }
            return get(0);
        }

        @SuppressWarnings("unchecked")
        public T get(int index) {
            if (index < 0 || index >= size()) {
                throw new IndexOutOfBoundsException("Index out of bounds: " + index);
            }
            T[] array = (T[]) Array.newInstance(Object.class, size());
            toArray(array);
            return array[index];
        }
    }
    public static void main(String[] args) {
        System.out.println("Car Driving Assist System Activated");
        
        MyPriorityQueue<Car> carQueue = new MyPriorityQueue<Car>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int speed = rand.nextInt(101); 
            int distance = rand.nextInt(101) - 50; 
            carQueue.add(new Car("Car " + (i+1), speed, distance));
        }

        boolean blinkerEngaged = false;
        Random randBlinker = new Random();
        int blinkerChance = randBlinker.nextInt(101); 
        if (blinkerChance < 25) {
            blinkerEngaged = true;
        }
        
        for (Car car : carQueue) {
            System.out.println(car.getName() + " speed: " + car.getSpeed() + " mph, distance: " + car.getDistance() + " m");
            activateDirectionalSignal(carQueue, blinkerEngaged);
        
            if (!blinkerEngaged) {
                if (car.getDistance() <= 30 && car.getDistance() >= -30) {
                    System.out.println("Car ahead! Slow down!");
                }
            }
        }
    }
}            