public interface Observer {
    //To handle notifications when a new message is sent in the chat room.
    void onNewMessage(Message message, ChatRoom chatRoom);

    //To handle notifications when a user joins or leaves the chat room.
    void onUserActivity(User user, ChatRoom chatRoom);
}
