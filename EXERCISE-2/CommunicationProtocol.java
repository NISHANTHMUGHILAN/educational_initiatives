public interface CommunicationProtocol {
    //Establishes a connection to the server or communication endpoint.
    void connect();

    //Closes the connection to the server or communication endpoint.
    void disconnect();

    //Sends a message using the specified communication protocol.
    void sendMessage(Message message);
}
