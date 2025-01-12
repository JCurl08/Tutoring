package main.model.log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PublicPrivateLog implements Iterable<String> {
    private List<Message> messages;
    private boolean includePrivate;

    // Creates a new PublicPrivateLog with no messages includePrivate
    public PublicPrivateLog(boolean includePrivate) {
        this.includePrivate = includePrivate;
        this.messages = new ArrayList<>();
    }

    // Creates a new empty PublicPrivateLog with includePrivate set to false
    public PublicPrivateLog() {
        this(false);
    }

    // adds a public message to messages
    public void addMessage(String message) {
        this.messages.add(new Message(message, true));
    }

    // adds a private message to messages
    public void addPrivateMessage(String message) {
        this.messages.add(new Message(message, false));
    }

    @Override
    public Iterator<String> iterator() {
        return new LogIterator();
    }

    private class LogIterator implements Iterator<String> {
        Iterator<Message> it;
        String next;

        public LogIterator() {
            it = messages.iterator();
            if (it.hasNext()) {
                if (includePrivate) {
                    next = it.next().getMessage();
                } else {
                    Message nextMessage = it.next();
                    while (!nextMessage.isPublic()) {
                        if (it.hasNext()) {
                            nextMessage = it.next();
                        } else {
                            next = null;
                            return;
                        }
                    }
                    next = nextMessage.getMessage();
                }
            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public String next() {
            String result = next;
            if (it.hasNext()) {
                if (includePrivate) {
                    next = it.next().getMessage();
                } else {
                    Message nextMessage = it.next();
                    while (!nextMessage.isPublic() && it.hasNext()) {
                        nextMessage = it.next();
                    }
                    if (nextMessage.isPublic()) {
                        next = nextMessage.getMessage();
                    } else {
                        next = null;
                    }
                }
            } else {
                next = null;
            }
            return next;
        }
    }
}
