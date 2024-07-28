public class User {
    private String username; //Stores the username of the user.

    //Initializes a new User object with a given username.
    public User(String username) {
        this.username = username;
    }
    //Retrieves the username of the user.
    public String getUsername() {
        return username;
    }

    //Sets or updates the username of the user.
    public void setUsername(String username) {
        this.username = username;
    }
}
