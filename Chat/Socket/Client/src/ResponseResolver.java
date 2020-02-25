import pojo.ChatMessage;
import pojo.IncomingMessage;
import pojo.SimpleMessage;
import pojo.Users;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;

public class ResponseResolver extends Thread {


    ObjectInputStream ois;
    Socket socket;


    public ResponseResolver(Socket socket, ObjectInputStream ois) {
        this.socket = socket;
        this.ois = ois;
        start();
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(100);
                Object o = ois.readObject();
                handleIncomingMessage(o);
            } catch (SocketException e) {
                System.out.println("Server Disconnected\nBye");
                break;
            } catch (IOException e) {
                System.out.println("Server Disconnected\nBye");
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void handleIncomingMessage(Object o) {
        try {
            IncomingMessage incomingMessage = (IncomingMessage) o;
            System.out.println(incomingMessage.getFrom() + " -> " + incomingMessage.getMessage());

        } catch (ClassCastException e) {
            handleUsers(o);
        }
    }

    void handleUsers(Object o) {
        try {
            Users users = (Users) o;
            if (users.getUsers().length == 0)
                System.out.println("You are alone");
            Arrays.stream(users.getUsers()).forEach(s -> System.out.println(s));
        } catch (ClassCastException e) {
            handleSimpleMessage(o);
        }
    }

    void handleSimpleMessage(Object o) {
        try {
            SimpleMessage simpleMessage = (SimpleMessage) o;
            if ("disconnect".equals(simpleMessage.getMessage())) {

            }

        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
}
