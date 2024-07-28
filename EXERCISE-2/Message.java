public class Message {
    private User sender; //Stores the User object that represents the sender of the message.
    private String content;//Stores the actual text content of the message.

    //Initializes a new Message object with a specified sender and content
    public Message(User sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    //Retrieves the sender of the message.
    public User getSender() {
        return sender;
    }

    //Sets or updates the sender of the message.
    public void setSender(User sender) {
        this.sender = sender;
    }

    //Retrieves the content of the message.
    public String getContent() {
        return content;
    }

    // Sets or updates the content of the message.
    public void setContent(String content) {
        this.content = content;
    }
}