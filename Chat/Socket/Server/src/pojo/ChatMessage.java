package pojo;

import java.io.Serializable;

public class ChatMessage implements Serializable {

    String to;
    String message;

    public ChatMessage() {
    }

    public ChatMessage(String to, String message) {
        this.to = to;
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
