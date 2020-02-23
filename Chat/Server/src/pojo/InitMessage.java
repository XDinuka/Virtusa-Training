package pojo;

import java.io.Serializable;

public class InitMessage implements Serializable {

    String username;

    public InitMessage() {
    }

    public InitMessage(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
