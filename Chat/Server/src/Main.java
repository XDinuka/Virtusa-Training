import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        try {
            System.setProperty("javax.net.ssl.keyStore", "/home/dinuka/Desktop/ssl/keys/ServerKeyStore.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", "123456");
            System.setProperty("javax.net.debug", "ssl:record");

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(5000);


            while (true) {
                Socket client = sslServerSocket.accept();
                RequestHandler cc = new RequestHandler(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
