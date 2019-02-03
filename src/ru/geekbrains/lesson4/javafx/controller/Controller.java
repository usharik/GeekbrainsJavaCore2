package ru.geekbrains.lesson4.javafx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import ru.geekbrains.lesson4.swing.Message;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public TextField tfMessage;

    @FXML
    public ListView lvMessages;

    @FXML
    public Button btSendMessage;

    Stage primaryStage;

    private ObservableList<Message> messageList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        messageList = FXCollections.observableArrayList();
        lvMessages.setItems(messageList);
        lvMessages.setCellFactory(new Callback<ListView, ListCell>() {
            @Override
            public ListCell call(ListView param) {
                return new MessageCellController();
            }
        });
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void onSendMessageClicked() {
        String text = tfMessage.getText();
        if (text != null && !text.isEmpty()) {
            messageList.add(new Message("user", text));
            tfMessage.clear();
            tfMessage.requestFocus();
        }
    }
}
