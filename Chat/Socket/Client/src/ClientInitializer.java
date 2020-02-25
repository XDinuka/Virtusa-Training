import pojo.InitMessage;
import pojo.SimpleMessage;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

public class ClientInitializer {

    public static void initialize(String ip,Integer port,InitMessage initMessage){

        System.setProperty("javax.net.ssl.trustStore", "/home/user/Desktop/training/Virtusa-Training/Chat/ssl/ca/ClientKeyStore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "123456");


        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(ip, port);

            sslSocket.startHandshake();


            ObjectOutputStream objectOutputStream = new ObjectOutputStream(sslSocket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(sslSocket.getInputStream());

            objectOutputStream.writeObject(initMessage);
            objectOutputStream.flush();


            SimpleMessage simpleMessage = (SimpleMessage) objectInputStream.readObject();

            if(simpleMessage.getMessage().equals("connected")){
                System.out.println("Connected");
                new InputResolver(sslSocket,objectOutputStream);
                new ResponseResolver(sslSocket,objectInputStream);
            }else{
                sslSocket.close();
                System.out.println("Username is taken. Try another");
                Main.start();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
