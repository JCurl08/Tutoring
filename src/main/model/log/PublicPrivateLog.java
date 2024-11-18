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

    public class LogIterator implements Iterator<String> {
        private Iterator<Message> messageIterator;
        private Message next;

        public LogIterator() {
            messageIterator = messages.iterator();
            if (messageIterator.hasNext()) {
                next = messageIterator.next();
                while (!includePrivate && !next.isPublic()) {
                    if (!messageIterator.hasNext()) {
                        next = null;
                        break;
                    }
                    next = messageIterator.next();
                }
            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public String next() {
            String result = next.getMessage();
            next = null;
            if (messageIterator.hasNext()) {
                next = messageIterator.next();
                while (!includePrivate && !next.isPublic()) {
                    if (!messageIterator.hasNext()) {
                        next = null;
                        break;
                    }
                    next = messageIterator.next();
                }
            }
            return result;
        }
    }
}
