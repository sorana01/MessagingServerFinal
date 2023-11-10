import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
    private final int maxSize;
    private Queue<QueueMessage> queue;

    public MessageQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new LinkedList<>();
    }

    public synchronized void addMessage(QueueMessage message) {
        if (queue.size() < maxSize) {
            queue.add(message);
        } else {
            // Handle the case where the queue is full
        }
    }

    public synchronized QueueMessage getMessageForRecipient(String recipient) {
        for (QueueMessage message : queue) {
            if (message.getRecipient().equals(recipient)) {
                queue.remove(message);
                return message;
            }
        }
        return null; // No message for this recipient
    }
}
