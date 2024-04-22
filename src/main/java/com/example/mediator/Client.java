package com.example.mediator;

public interface Client {
    void receive(String message);
    void send(String message);
    String getId();
}
