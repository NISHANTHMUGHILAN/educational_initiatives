import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomId; //'roomId': A unique identifier for the chat room.
    private List<User> users; //'users': A list of User objects currently in the chat room.
    private List<Message> messages; //'messages': A list of Message objects sent in the chat room.
    private List<Observer> observers; //'observers': A list of Observer objects that receive notifications about changes in the chat room.

    public ChatRoom(String roomId) {
        //Initializing the ChatRoom with a given roomId.
        //Initializing empty lists for users, messages, and observers
        this.roomId = roomId;
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    //Getters and setters: Provide access to and modification of the roomId, users, and messages properties.
    public String getRoomId() {
        return roomId;
    }

    public List<User> getUsers() {
        return users;
    }

    //addUser(User user): Adds a user to the chat room and notifies observers about this user activity.
    public void addUser(User user) {
        users.add(user);
        notifyObserversUserActivity(user);
    }

    //removeUser(User user): Removes a user from the chat room and notifies observers about this user activity.
    public void removeUser(User user) {
        users.remove(user);
        notifyObserversUserActivity(user);
    }

    //sendMessage(Message message): Adds a message to the list of messages and notifies observers about the new message.
    public void sendMessage(String senderUsername, String receiverUsername, String messageContent) {
        User sender = findUserByUsername(senderUsername);
        User receiver = findUserByUsername(receiverUsername);

        if (sender != null && receiver != null) {
            Message message = new Message(sender, messageContent);
            messages.add(message);
            notifyObserversNewMessage(message);
        } else {
            if (sender == null) {
                System.out.println("Sender not found in the chat room.");
            }
            if (receiver == null) {
                System.out.println("Receiver not found in the chat room.");
            }
        }
    }

    private User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    //addObserver(Observer observer): Adds an Observer to the list of observers.
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    //removeObserver(Observer observer): Removes an Observer from the list.
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    //notifyObserversNewMessage(Message message): Iterates over the list of observers and calls onNewMessage() on each observer, passing the new message and the chat room.
    private void notifyObserversNewMessage(Message message) {
        for (Observer observer : observers) {
            observer.onNewMessage(message, this);
        }
    }

    //notifyObserversUserActivity(User user): Iterates over the list of observers and calls onUserActivity() on each observer, passing the user and the chat room.
    private void notifyObserversUserActivity(User user) {
        for (Observer observer : observers) {
            observer.onUserActivity(user, this);
        }
    }

    //displayChatMessages(): Constructs a string representation of all messages in the chat room.
    public String displayChatMessages() {
        StringBuilder sb = new StringBuilder();
        for (Message message : messages) {
            sb.append(message.getSender().getUsername())
              .append(": ")
              .append(message.getContent())
              .append("\n");
        }
        return sb.toString();
    }

    //displayActiveUsers(): Constructs a string representation of all active users in the chat room.
    public String displayActiveUsers() {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.getUsername())
              .append("\n");
        }
        return sb.toString();
    }
}