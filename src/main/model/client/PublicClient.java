package main.model.client;

import main.model.log.PublicPrivateLog;
import main.model.log.Message;

public class PublicClient implements Client {
    private String name;
    private PublicPrivateLog log;

    // Creates new public client with name and an empty log
    PublicClient(String name) {
        this.name = name;
        this.log = new PublicPrivateLog();
    }

    @Override
    public void update(String message) {
        log.addMessage(message);
    }

    @Override
    public void printLog() {
        for (String message : log) {
            System.out.println(message);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
