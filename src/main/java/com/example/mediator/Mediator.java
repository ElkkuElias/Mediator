package com.example.mediator;

public interface Mediator {
    void message(String message, String ID);
    void addClient(Client client);
}
