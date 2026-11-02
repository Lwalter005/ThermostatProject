package org.fooddoodsinc.thermostatproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ThermostatApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ThermostatApplication.class.getResource("thermostat-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Thermostat");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}