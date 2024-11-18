package main.model.log;

public class Message {
    private String message;
    private boolean isPublic;

    public Message(String message, boolean isPublic) {
        this.message = message;
        this.isPublic = isPublic;
    }

    // getters
    public String getMessage() {
        return this.message;
    }

    public boolean isPublic() {
        return this.isPublic;
    }
}
