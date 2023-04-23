package com.dashboard.autodashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AutoDashboard extends Main {
    private JFrame frame;
    private JLabel odometerLabel, speedometerLabel, fuelGaugeLabel, temperatureGaugeLabel, warningLightsLabel;
    private JPanel panel;

    public static void main(String[] args) {
        // Create the window
        frame = new JFrame("Auto Dashboard");

        // Create the labels
        odometerLabel = new JLabel(("Odometer: " + getCurrentDistance()));
        speedometerLabel = new JLabel(("Speedomemeter: " + getSpeed()));
        fuelGaugeLabel = new JLabel(("Fuel: " + getFuelLevel()));
        temperatureGaugeLabel = new JLabel("Temp: " + getTemperature());
        warningLightsLabel = new JLabel("Warning Lights: " + getWarningLightsStatus());

                // Create the panel
                panel = new JPanel();
                panel.setLayout(new GridLayout(5, 1));
                panel.add(odometerLabel);
                panel.add(speedometerLabel);
                panel.add(fuelGaugeLabel);
                panel.add(temperatureGaugeLabel);
                panel.add(warningLightsLabel);
        
                // Add the panel to the frame
                frame.getContentPane().add(panel);
        
                // Set the size and position of the window
                frame.setSize(400, 300);
                frame.setLocationRelativeTo(null); // Center the window on the screen
        
                // Show the window
                frame.setVisible(true);
            }
        
            // Helper methods to get the current values for the dashboard elements
            private String getCurrentDistance() {
                Odometer odometer = new Odometer();
                return Integer.toString(odometer.getCurrentDistance());
            }
        
            private String getSpeed() {
                Speedometer speedometer = new Speedometer();
                return Integer.toString(speedometer.getCurrentSpeed());
            }
        
            private String getFuelLevel() {
                FuelGauge fuelGauge = new FuelGauge();
                return Integer.toString(fuelGauge.getFuelLevel());
            }
        
            private String getTemperature() {
                TemperatureGauge temperatureGauge = new TemperatureGauge();
                return Integer.toString(temperatureGauge.getTemperature());
            }
        
            private String getWarningLightsStatus() {
                WarningLights warningLights = new WarningLights();
                return warningLights.getStatus();
            }
        
            public static void main(String[] args) {
                AutoDashboardGUI dashboard = new AutoDashboardGUI();
            }
        }
    }
}