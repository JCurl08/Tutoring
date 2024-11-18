package main.model.member;

import main.model.client.Client;

import java.util.ArrayList;
import java.util.List;

public abstract class Member {
    private String name;
    private List<Client> clients;

    // Creates a new Member with name and empty list of clients
    public Member(String name) {
    }

    // Getters and setters
    public String getName() {
        return "";
    }

    protected List<Client> getClients() {
        return null;
    }

    // Calculates the total salary costs for an employee or a department
    // including employees of the department and its sub departments.
    public abstract int getSalaryCosts();

    // Adds client to the list of clients and notifies the client that it is a client of the department
    public void addClient(Client client) {
        // stub
    }

    // Removes the client from the client list and notifies the client.
    public void removeClient(Client client) {
        // stub
    }

    // Notifies all clients in the client list
    // Further notifies all clients of the employees and sub-departments
    public abstract void notifyClients(String message);
}
