import pojo.InitMessage;
import pojo.SimpleMessage;

import javax.net.SocketFactory;
import java.io.*;
import java.net.Socket;

public class ClientInitializer {

    public static void initialize(String ip,Integer port,InitMessage initMessage){

        SocketFactory socketFactory = SocketFactory.getDefault();

        try {
            Socket socket =  socketFactory.createSocket(ip, port);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            objectOutputStream.writeObject(initMessage);
            objectOutputStream.flush();


            SimpleMessage simpleMessage = (SimpleMessage) objectInputStream.readObject();

            if(simpleMessage.getMessage().equals("connected")){
                System.out.println("Connected");
                new InputResolver(socket,objectOutputStream);
                new ResponseResolver(socket,objectInputStream);
            }else{
                socket.close();
                System.out.println("Username is taken. Try another");
                Main.start();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
