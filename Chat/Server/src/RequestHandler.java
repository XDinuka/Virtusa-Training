
import pojo.*;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RequestHandler extends Thread {

    Socket socket;
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;
    Boolean continueLoop = true;
    String username;


    public RequestHandler(Socket socket) {
        this.socket = socket;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.start();
    }

    public void run() {


        try {
            while (continueLoop) {
                Object o = objectInputStream.readObject();


                handleChatMessage(o);
            }


            socket.close();
        } catch (SocketException e) {
            UserStore.unregister(username);
        } catch (UnrecognizedMessageException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessages(List<IncomingMessage> messages) {
        try {
            System.out.println(messages.size() + username);
            messages.stream().forEach(message -> {
                try {
                    objectOutputStream.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                    continueLoop = false;
                }
            });
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            continueLoop = false;
        }
    }

    void handleChatMessage(Object o) throws UnrecognizedMessageException {
        try {
            ChatMessage chatMessage = (ChatMessage) o;


            MessageQueue.storeMessage(chatMessage.getTo(), new IncomingMessage(username, chatMessage.getMessage()));


        } catch (ClassCastException c) {
            handleSimpleMessage(o);
        }
    }

    void handleSimpleMessage(Object o) throws UnrecognizedMessageException {
        try {
            SimpleMessage simpleMessage = (SimpleMessage) o;
            if (simpleMessage.getMessage().equals("list")) {
                String[] usernames = UserStore.getUsernames().stream().filter(s -> !s.equals(username)).toArray(String[]::new);
                objectOutputStream.writeObject(new Users(usernames));
                objectOutputStream.flush();
            } else if (simpleMessage.getMessage().equals("quit")) {
                UserStore.unregister(username);
                continueLoop = false;
            }

        } catch (ClassCastException c) {
            handleInitMessage(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void handleInitMessage(Object o) throws UnrecognizedMessageException {
        try {
            InitMessage initMessage = (InitMessage) o;
            if (UserStore.isUsernameTaken(initMessage.getUsername())) {
                objectOutputStream.writeObject(new SimpleMessage("taken"));
            } else {
                UserStore.register(initMessage.getUsername(), socket);
                objectOutputStream.writeObject(new SimpleMessage("connected"));
                username = initMessage.getUsername();

                new Thread(() -> {
                    int i = 1;
                    while (continueLoop) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {

                        }
                        List<IncomingMessage> messages = MessageQueue.getMessages(username);

                        if (!messages.isEmpty())
                            sendMessages(messages);
                    }

                }).start();


            }

            objectOutputStream.flush();

        } catch (ClassCastException c) {
            throw new UnrecognizedMessageException();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


}

class UnrecognizedMessageException extends Exception {
}