package main.model.client;

import main.model.log.PublicPrivateLog;

public class PrivateClient implements Client{
    private PublicPrivateLog log;
    private PublicPrivateLog privateLog;
    private boolean includePrivate;

    // Creates new PrivateClient with an empty log, empty privateLog and includePrivate set to false
    public PrivateClient() {
        this.log = new PublicPrivateLog();
        this.privateLog = new PublicPrivateLog(true);
        this.includePrivate = false;
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
            this.privateLog.addPrivateMessage(message);
        } else {
            this.log.addMessage(message);
            this.privateLog.addMessage(message);
        }
    }

    @Override
    public void printLog() {
        if (this.includePrivate) {
            for (String message : this.privateLog) {
                System.out.println(message);
            }
        } else {
            for (String message : this.log) {
                System.out.println(message);
            }
        }
    }
}
