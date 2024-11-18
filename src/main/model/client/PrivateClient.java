package main.model.client;

import main.model.log.PublicPrivateLog;

public class PrivateClient implements Client {
    PublicPrivateLog log;
    PublicPrivateLog privateLog;
    boolean includePrivate;

    // Creates new PrivateClient with an empty log, empty privateLog and includePrivate set to false
    public PrivateClient() {
        this.log = new PublicPrivateLog(false);
        this.privateLog = new PublicPrivateLog(true);
        includePrivate = false;
    }

    // Getters and setters
    public void setIncludePrivate(boolean includePrivate) {
        this.includePrivate = includePrivate;
    }

    @Override
    public String getName() {
        return "Private Client";
    }

    @Override
    public void update(String message) {
        if (message.startsWith("private message")) {
            privateLog.addPrivateMessage(message);
            log.addPrivateMessage(message);
        } else {
            privateLog.addMessage(message);
            log.addMessage(message);
        }
    }

    @Override
    public void printLog() {
        if (includePrivate) {
            for (String message : privateLog) {
                System.out.println(message);
            }
        } else {
            for (String message : log) {
                System.out.println(message);
            }
        }
    }
}
