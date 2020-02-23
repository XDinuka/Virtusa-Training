
import pojo.ChatMessage;
import pojo.SimpleMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.NoSuchElementException;

public class InputResolver extends Thread {

    Socket socket;
    ObjectOutputStream oos;

    public InputResolver(Socket socket, ObjectOutputStream oos) {
        this.socket = socket;
        this.oos = oos;
        start();
    }

    @Override
    public void run() {
        while (true) {
            try {


                String s = Main.scanner.nextLine();
                if (s.equals("list")) {
                    oos.writeObject(new SimpleMessage("list"));
                    oos.flush();
                } else if (s.matches("send .* -> .*")) {
                    String[] substring = s.substring(5).split(" -> ");
                    oos.writeObject(new ChatMessage(substring[1], substring[0]));
                    oos.flush();
                } else if (s.equals("quit")) {

                        oos.writeObject(new SimpleMessage("quit"));
                        socket.close();

                    break;
                } else {
                    System.out.println("Invalid Input");

                }

            }catch (SocketException e){
                break;
//            } catch (InterruptedException e) {

            } catch (NoSuchElementException e) {
                e.printStackTrace();
            } catch (IOException e) {
                break;
            }


        }
    }


}
