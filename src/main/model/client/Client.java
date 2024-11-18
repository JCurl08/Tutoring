package main.model.client;

public interface Client {
    // returns the name of a publicClient or "Private Client" otherwise
    String getName();

    // Stores the message. If the client is private and the message begins with "private message"
    // then the message is stored as a private message.
    void update(String message);

    // Prints the messages in the log to console.
    // Prints all messages if PublicClient or includePrivate is set to true for PrivateClients
    void printLog();
}
