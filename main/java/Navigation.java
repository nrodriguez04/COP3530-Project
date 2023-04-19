/* 
COP 3530 PROJECT
NAVIGATION FEATURE
CONTRIBUTOR NICOLAS RODRIGUEZ
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Collections;

public class Navigation {

    private String currentLocation;
    private String destination;
    private Map<String, List<Edge>> graph;

    public Navigation() {
        currentLocation = "";
        destination = "";
        graph = new HashMap<>();
    }

    public List<String> getDirections() {
        List<String> directions = new ArrayList<>();
        if (!currentLocation.isEmpty() && !destination.isEmpty()) {
            // Build the graph
            buildGraph();

            // Use Dijkstra's algorithm to find the shortest path
            Map<String, Double> distances = new HashMap<>();
            Map<String, String> previous = new HashMap<>();
            PriorityQueue<String> unvisitedNodes = new PriorityQueue<>(
                    (s1, s2) -> Double.compare(distances.getOrDefault(s1, Double.POSITIVE_INFINITY),
                            distances.getOrDefault(s2, Double.POSITIVE_INFINITY)));

            for (String vertex : graph.keySet()) {
                distances.put(vertex, Double.POSITIVE_INFINITY);
                previous.put(vertex, null);
                unvisitedNodes.offer(vertex);
            }

            distances.put(currentLocation, 0.0);

            while (!unvisitedNodes.isEmpty()) {
                String current = unvisitedNodes.poll();
                if (current.equals(destination)) {
                    break;
                }
                if (distances.get(current) == Double.POSITIVE_INFINITY) {
                    break;
                }

                for (Edge neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                    double distance = distances.get(current) + neighbor.weight;
                    if (distance < distances.getOrDefault(neighbor.destination, Double.POSITIVE_INFINITY)) {
                        distances.put(neighbor.destination, distance);
                        previous.put(neighbor.destination, current);
                        unvisitedNodes.remove(neighbor.destination);
                        unvisitedNodes.offer(neighbor.destination);
                    }
                }
            }

            // Convert the path to turn-by-turn directions
            String current = destination;
            while (!current.equals(currentLocation)) {
                String prev = previous.get(current);
                directions.add("Go from " + prev + " to " + current);
                current = prev;
            }
            Collections.reverse(directions);
        }
        return directions;
    }

    public void setCurrentLocation(String location) {
        currentLocation = location;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    private void buildGraph() {
        // Build the graph by adding edges between vertices
        graph.clear();
        // Add edges between vertices based on the roads and intersections in the area
    }

    private static class Edge {
        private final String destination;
        private final double weight;

        private Edge(String destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
