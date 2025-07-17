// src/main/java/model/User.java
package model;

public class User {
    private int id;
    private String username;
    private String passwordHash;

    public User(int id, String username, String passwordHash) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    // getter/setter...
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
}
