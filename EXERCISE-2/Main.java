import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChatRoomManager chatRoomManager = ChatRoomManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Create/Join Chat Room");
            System.out.println("2. Add Users to Chat Room");
            System.out.println("3. Send Message");
            System.out.println("4. Display Chat Messages");
            System.out.println("5. Display Active Users");
            System.out.println("6. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter Chat Room ID to create/join: ");
                    String roomId = scanner.nextLine();
                    try {
                        chatRoomManager.createChatRoom(roomId);
                        System.out.println("Chat room created/joined successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter Chat Room ID: ");
                    roomId = scanner.nextLine();
                    System.out.println("Enter usernames to add to the chat room (type 'done' to stop): ");
                    try {
                        while (true) {
                            String username = scanner.nextLine();
                            if (username.equalsIgnoreCase("done")) {
                                break;
                            }
                            User user = new User(username);
                            chatRoomManager.joinChatRoom(roomId, user);
                            System.out.println("User " + username + " added to the chat room.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter Chat Room ID: ");
                    roomId = scanner.nextLine();
                    System.out.print("Enter sender username: ");
                    String senderUsername = scanner.nextLine();
                    System.out.print("Enter receiver username: ");
                    String receiverUsername = scanner.nextLine();
                    System.out.print("Enter message content: ");
                    String messageContent = scanner.nextLine();

                    try {
                        chatRoomManager.sendMessage(roomId, senderUsername, receiverUsername, messageContent);
                        System.out.println("Message sent successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter Chat Room ID: ");
                    roomId = scanner.nextLine();
                    try {
                        ChatRoom chatRoom = chatRoomManager.getChatRoom(roomId);
                        System.out.println("Chat Messages:");
                        System.out.println(chatRoom.displayChatMessages());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter Chat Room ID: ");
                    roomId = scanner.nextLine();
                    try {
                        ChatRoom chatRoom = chatRoomManager.getChatRoom(roomId);
                        System.out.println("Active Users:");
                        System.out.println(chatRoom.displayActiveUsers());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}