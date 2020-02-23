import javax.net.ServerSocketFactory;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static final int HTTP_PORT = 5000;

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        try {
            ServerSocketFactory ssf = ServerSocketFactory.getDefault();
            ServerSocket serverSocket = ssf.createServerSocket(HTTP_PORT);
            while (true) {
                Socket client = serverSocket.accept();
                RequestHandler cc = new RequestHandler(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
