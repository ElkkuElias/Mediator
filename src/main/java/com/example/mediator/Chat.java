package com.example.mediator;

import java.util.ArrayList;
import java.util.List;

public class Chat implements Mediator {
    private List<ChatClient> clients;

    public Chat() {
        this.clients = new ArrayList<>();
    }

    @Override
    public void addClient(Client client) {
        this.clients.add((ChatClient) client);
    }

    @Override
    public void message(String msg, String userId) {
        for (ChatClient client : clients) {

                client.receive(msg);

        }
    }


}
