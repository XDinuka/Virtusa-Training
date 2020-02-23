import java.net.Socket;
import java.util.HashMap;
import java.util.Set;

public class UserStore {

    private static final HashMap<String, Socket> usersMap = new HashMap<>();


    public static Boolean isUsernameTaken(String username) {
        return usersMap.containsKey(username);
    }


    public static synchronized Boolean register(String username, Socket socket) {
        if (!isUsernameTaken(username)) {
            usersMap.put(username, socket);
            return true;
        }
        return false;
    }

    public static void unregister(String username) {
        usersMap.remove(username);
    }

    public static Set<String> getUsernames() {
        return usersMap.keySet();
    }


}
