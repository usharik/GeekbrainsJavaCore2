package ru.geekbrains.lesson4.javafx.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import ru.geekbrains.lesson4.swing.Message;

import java.io.IOException;

public class MessageCellController extends ListCell<Message> {

    @FXML
    public Label lbUserName;

    @FXML
    public Label lbMessage;

    @FXML
    public BorderPane cellLayout;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Message msg, boolean empty) {
        super.updateItem(msg, empty);

        if(empty || msg == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/fxml/message_cell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            lbUserName.setText(msg.getUserFrom());
            lbMessage.setText(msg.getText());
            setText(null);
            setGraphic(cellLayout);
        }
    }
}
