package pojo;

import java.io.Serializable;

public class Users implements Serializable {

    String[] users;

    public Users() {
    }

    public Users(String[] users) {
        this.users = users;
    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }
}
