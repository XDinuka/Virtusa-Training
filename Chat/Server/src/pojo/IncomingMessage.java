package pojo;

import java.io.Serializable;

public class IncomingMessage implements Serializable {

    String from;
    String message;

    public IncomingMessage() {
    }

    public IncomingMessage(String from, String message) {
        this.from = from;
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
