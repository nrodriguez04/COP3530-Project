package com.dashboard.autodashboard;

/* 
COP 3530 PROJECT
AUTOMATIC HEADLIGHTS CAR FEATURE
CONTRIBUTOR AJ CARDOZA
*/

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Headlights {

    public static class Weather {
        private String condition;
        private int temperature;

        public Weather(String condition, int temperature) {
            this.condition = condition;
            this.temperature = temperature;
        }

        public String getCondition() {
            return condition;
        }

        public int getTemperature() {
            return temperature;
        }

        public LocalDateTime getNightStartTime() {
            LocalDateTime now = LocalDateTime.now();
            int hour = now.getHour();
            if (hour >= 18) {
                return LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 0));
            } else {
                return LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(18, 0));
            }
        }
    }

    public static class TreeNode {
        private String condition;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(String condition) {
            this.condition = condition;
            this.left = null;
            this.right = null;
        }

        public void insertLeft(TreeNode node) {
            this.left = node;
        }

        public void insertRight(TreeNode node) {
            this.right = node;
        }

        public boolean evaluate(Weather weather) {
            switch (condition) {
                case "Rain":
                    return weather.getCondition().equals("Rain");
                case "Snow":
                    return weather.getCondition().equals("Snow");
                case "Night":
                    return LocalDateTime.now().isAfter(weather.getNightStartTime());
                case "Poor visibility":
                    return weather.getCondition().equals("Rain") || weather.getCondition().equals("Snow");
                case "Headlights on":
                    return true;
                default:
                    throw new IllegalArgumentException("Invalid condition: " + condition);
            }
        }
    }

    private static Weather generateRandomWeather() {
        Random rand = new Random();
        String[] conditions = { "Sunny", "Cloudy", "Rain", "Snow" };
        String condition = conditions[rand.nextInt(conditions.length)];
        int temperatureCelsius = rand.nextInt(121) - 10;
        int temperatureFahrenheit = temperatureCelsius * 9 / 5 + 32;
        temperatureFahrenheit = Math.min(temperatureFahrenheit, 98);
        Weather weather = new Weather(condition, temperatureFahrenheit);
        return weather;
    }

    public static boolean evaluateTree(TreeNode node, Weather weather) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return node.evaluate(weather);
        }
        boolean left = evaluateTree(node.left, weather);
        boolean right = evaluateTree(node.right, weather);
        if (node.condition.equals("Poor visibility") && (left || right)) {
            return node.evaluate(weather);
        }
        return left || right;
    }

    public static void main(String[] args) {
        System.out.println("Ford Weather System Sucsessfully Activated");

        Weather weather = generateRandomWeather();
        System.out.print("Current weather: " + weather.getCondition());
        System.out.print(", Temperature: " + weather.getTemperature());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedTime = now.format(formatter);
        System.out.println(", Time: " + formattedTime);

        TreeNode rainyNode = new TreeNode("Raining");
        TreeNode snowyNode = new TreeNode("Snowing");
        TreeNode nightNode = new TreeNode("Night");
        TreeNode poorVisibilityNode = new TreeNode("Poor visibility");
        TreeNode headlightsOnNode = new TreeNode("Headlights on");

        rainyNode.insertLeft(headlightsOnNode);
        snowyNode.insertLeft(headlightsOnNode);
        nightNode.insertLeft(headlightsOnNode);

        poorVisibilityNode.insertLeft(poorVisibilityNode);
        poorVisibilityNode.insertRight(headlightsOnNode);

        boolean shouldTurnOnHeadLights = evaluateTree(nightNode, weather);

        if (shouldTurnOnHeadLights) {
            System.out.println("Inclement weather detected, headlights sucssessfully activated");
        }
    }
}