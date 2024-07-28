import java.util.HashMap;
import java.util.Map;

public class ChatRoomManager {
    private static ChatRoomManager instance;// Holds the singleton instance of the ChatRoomManager.
    private Map<String, ChatRoom> chatRooms;// Stores a mapping of chat room IDs to ChatRoom objects.

    //Initializes the ChatRoomManager instance with an empty map of chat rooms.
    private ChatRoomManager() {
        chatRooms = new HashMap<>();
    }

    // Provides access to the singleton instance of ChatRoomManager.
    public static synchronized ChatRoomManager getInstance() {
        if (instance == null) {
            instance = new ChatRoomManager();
        }
        return instance;
    }

    //Creates a new chat room with the specified ID if it doesn’t already exist.
    public void createChatRoom(String roomId) throws IllegalArgumentException {
        if (!chatRooms.containsKey(roomId)) {
            chatRooms.put(roomId, new ChatRoom(roomId));
        } else {
            throw new IllegalArgumentException("Chat room already exists");
        }
    }

    //Adds a user to the specified chat room.
    public void joinChatRoom(String roomId, User user) throws IllegalArgumentException {
        if (chatRooms.containsKey(roomId)) {
            ChatRoom chatRoom = chatRooms.get(roomId);
            chatRoom.addUser(user);
        } else {
            throw new IllegalArgumentException("Invalid room ID");
        }
    }

    // Sends a message to the specified chat room.
    public void sendMessage(String roomId, String senderUsername, String receiverUsername, String messageContent) throws IllegalArgumentException {
        if (chatRooms.containsKey(roomId)) {
            ChatRoom chatRoom = chatRooms.get(roomId);
            chatRoom.sendMessage(senderUsername, receiverUsername, messageContent);
        } else {
            throw new IllegalArgumentException("Invalid room ID");
        }
    }

    public ChatRoom getChatRoom(String roomId) throws IllegalArgumentException {
        if (chatRooms.containsKey(roomId)) {
            return chatRooms.get(roomId);
        } else {
            throw new IllegalArgumentException("Invalid room ID");
        }
    }
}