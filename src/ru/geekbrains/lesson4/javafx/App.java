package ru.geekbrains.lesson4.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
        primaryStage.show();
    }
}
