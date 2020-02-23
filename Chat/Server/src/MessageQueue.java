import pojo.IncomingMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageQueue {

    public static Map<String, List<IncomingMessage>> messages = new HashMap<>();

    public static List<IncomingMessage> getMessages(String username){
            List<IncomingMessage> strings = messages.remove(username);
            if(strings==null)
                strings = new ArrayList<>();
            return strings;
    }

    public static void storeMessage(String username, IncomingMessage incomingMessage){
        List<IncomingMessage> incomingMessages = messages.get(username);
        if(incomingMessages==null){
            incomingMessages = new ArrayList<>();
            messages.put(username,incomingMessages);
        }
        incomingMessages.add(incomingMessage);
    }

}
