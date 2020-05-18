import java.util.ArrayList;

public class Message {

    private String text;
    private ArrayList<String> receivers;
    private Integer messageScope;

    public Message() {
        receivers = new ArrayList<>();
        messageScope = MessageScope.SYSTEM_ADMIN;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getReceivers() {
        return receivers;
    }

    public Integer getMessageScope() {
        return messageScope;
    }

    public void setMessageScope(Integer messageScope) {
        if(messageScope>MessageScope.SYSTEM_ADMIN || messageScope<MessageScope.STUDENT){
            throw new RuntimeException("Invalid Message Scope "+messageScope);
        }

        this.messageScope = messageScope;
    }



}
