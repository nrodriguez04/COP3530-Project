package com.dashboard.autodashboard;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AutoDashboardGUI extends Main {

    @Override
    public void start(Stage primaryStage) {
        // Create the main scene
        Scene scene = new Scene(new VBox(), 300, 200);

        // Add the odometer label
        Label odometerLabel = new Label("Odometer: ");
        scene.add(odometerLabel);

        // Add the fuel gauge
        ProgressBar fuelGauge = new ProgressBar(0.0);
        scene.add(fuelGauge);

        // Add the speedometer
        Label speedometerLabel = new Label("Speedometer: ");
        scene.add(speedometerLabel);

        // Add the temperature gauge
        ImageView temperatureGauge = new ImageView(new Image("temperature_gauge.png"));
        scene.add(temperatureGauge);

        // Add the warning lights label
        Label warningLightsLabel = new Label("Warning Lights: ");
        scene.add(warningLightsLabel);

        // Connect the widgets to the sensors in your car
        // ...

        // Show the main scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}