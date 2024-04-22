package com.example.mediator;

import javafx.scene.control.TextArea;

public class ChatClient implements Client{
    private Mediator mediator;
    private String id;
    private TextArea chatWindow;

    public ChatClient(Mediator mediator, String id, TextArea chatWindow) {
        this.mediator = mediator;
        this.id = id;
        this.chatWindow = chatWindow;
        this.mediator.addClient( this);
    }

    @Override
    public void send(String msg) {
        mediator.message(msg, id);
    }

    @Override
    public void receive(String msg) {
        chatWindow.appendText(msg + "\n");
    }

    @Override
    public String getId() {
        return id;
    }
}
