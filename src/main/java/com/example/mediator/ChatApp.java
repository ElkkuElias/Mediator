package com.example.mediator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatApp extends Application {
    private Mediator mediator = new Chat();

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        // Create tabs for multiple users
        createClientTab(tabPane, "User1");
        createClientTab(tabPane, "User2");
        createClientTab(tabPane, "User3");

        Scene scene = new Scene(tabPane, 400, 300);
        primaryStage.setTitle("Chat");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createClientTab(TabPane tabPane, String username) {
        TextArea chatArea = new TextArea();
        TextField inputField = new TextField();
        Button sendButton = new Button("Send");

        Client client = new ChatClient(mediator, username, chatArea);

        sendButton.setOnAction(e -> {
            client.send(username + ": " + inputField.getText());
            inputField.clear();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(chatArea, inputField, sendButton);

        Tab tab = new Tab(username, layout);
        tabPane.getTabs().add(tab);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
