package com.dashboard.autodashboard;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AutoDashboardGUI extends Main {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create a button with a label
        Button button = new Button("Click me!");

        // Create a layout pane and add the button to it
        StackPane layout = new StackPane();
        layout.setPadding(new Insets(10));
        layout.getChildren().add(button);

        // Create a scene with the layout pane as its root node
        Scene scene = new Scene(layout, 300, 200);

        // Set the scene of the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
