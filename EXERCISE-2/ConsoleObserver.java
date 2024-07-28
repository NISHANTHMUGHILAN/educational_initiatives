//ConsoleObserver: This class implements the Observer interface, which defines methods for reacting to events in the ChatRoom.
public class ConsoleObserver implements Observer {
    @Override
    public void onNewMessage(Message message, ChatRoom chatRoom) {
        System.out.println("New message in " + chatRoom.getRoomId() + ": " + message.getSender().getUsername() + ": " + message.getContent());
    }

    //Handles notifications when a user joins or leaves the chat room.
    @Override
    public void onUserActivity(User user, ChatRoom chatRoom) {
        System.out.println("User activity in " + chatRoom.getRoomId() + ": " + user.getUsername());
        System.out.println("Active users: " + chatRoom.displayActiveUsers());
    }
}
//Design Pattern: Implements the Observer Pattern, which allows the ChatRoom to notify this observer about changes without needing to know the specifics of the observer.