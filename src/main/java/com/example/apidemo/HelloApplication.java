package com.example.apidemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX and Gson Example");

        Label label = new Label("Press the button to fetch data from API");
        Button button = new Button("Fetch Data");

        VBox vbox = new VBox(label, button);
        vbox.setSpacing(10);

        button.setOnAction(e -> fetchDataFromApi(label));

        Scene scene = new Scene(vbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void fetchDataFromApi(Label label) {
        new Thread(() -> {
            try {
                APIResponse[] response = APIService.fetchData();
                StringBuilder result = new StringBuilder("API Response:\n");
                for (APIResponse post : response) {
                    result.append(post.getSetup()).append("\n");

                }
                for (APIResponse post : response){
                    result.append(post.getPunchline()).append("\n");
                }
                Platform.runLater(() -> label.setText(result.toString()));
            } catch (Exception ex) {
                Platform.runLater(() -> label.setText("Failed to fetch data"));
                ex.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

