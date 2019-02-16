package ru.geekbrains.lesson4.javafx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ru.geekbrains.lesson4.javafx.controller.Controller;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/scene.fxml"));
        Parent root = loader.load();
        Controller ctrl = loader.getController();
        ctrl.setPrimaryStage(primaryStage);

        primaryStage.setTitle("Network Chat");
        primaryStage.setScene(new Scene(root));
        primaryStage.setOnHidden(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                ctrl.closeNetworkConnection();
            }
        });
        primaryStage.show();
    }
}
