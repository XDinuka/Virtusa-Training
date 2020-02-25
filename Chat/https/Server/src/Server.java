import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpsServer;

import javax.net.ssl.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {

    static Map<String, ArrayList<String>> users = new HashMap<>();

    public static void main(String[] args) {

//        System.setProperty("javax.net.debug","all");

        try {

            FileInputStream fileInputStream = new FileInputStream("/home/user/Desktop/training/Virtusa-Training/Chat/ssl/keys/DebKeyStore.jks");
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(fileInputStream, "123456".toCharArray());

            KeyManagerFactory key = KeyManagerFactory.getInstance("SunX509");
            key.init(keystore, "123456".toCharArray());

            TrustManagerFactory trust = TrustManagerFactory.getInstance("SunX509");
            trust.init(keystore);

            HttpsServer httpsServer = HttpsServer.create(new InetSocketAddress(5000), 0);
            SSLContext context = SSLContext.getInstance("TLS");

            context.init(key.getKeyManagers(), trust.getTrustManagers(), null);

            httpsServer.setHttpsConfigurator(new HttpsConfigurator(context) {
                @Override
                public void configure(HttpsParameters httpsParameters) {
                    SSLContext sslContext = getSSLContext();
                    SSLEngine sslEngine = sslContext.createSSLEngine();
                    httpsParameters.setNeedClientAuth(false);
                    httpsParameters.setCipherSuites(sslEngine.getEnabledCipherSuites());
                    httpsParameters.setProtocols(sslEngine.getEnabledProtocols());
                    SSLParameters defaultSSLParameters = sslContext.getSupportedSSLParameters();
                    httpsParameters.setSSLParameters(defaultSSLParameters);
                }
            });


            httpsServer.createContext("/connect", Server::handleConnect);
            httpsServer.createContext("/send", Server::handleSend);
            httpsServer.createContext("/receive", Server::handleReceive);
            httpsServer.createContext("/list", Server::handleList);
            httpsServer.createContext("/disconnect", Server::handleDisconnect);
            httpsServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void handleDisconnect(HttpExchange httpExchange) {
        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));
        try {
            String name = bufferedReader.readLine();
            bufferedReader.close();
            String response = "User doesn't exist";
            if (users.containsKey(name)) {
                users.remove(name);
                response = "Disconnected";
            }
            httpExchange.sendResponseHeaders(200, response.length());
            bufferedWriter.write(response);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpExchange.close();
        }
    }

    private static void handleList(HttpExchange httpExchange) {
        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));
        try {
            String name = bufferedReader.readLine();
            bufferedReader.close();
            StringBuffer responseBuffer = new StringBuffer();
            users.keySet().stream()
                    .filter(s -> !s.equals(name))
                    .forEach(s -> {
                        responseBuffer.append(s);
                        responseBuffer.append("%%");
                    });
            String response = responseBuffer.toString();
            httpExchange.sendResponseHeaders(200, response.length());
            bufferedWriter.write(response);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpExchange.close();
        }
    }

    private static void handleSend(HttpExchange httpExchange) {
        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));
        try {
            String name = bufferedReader.readLine();
            String to = bufferedReader.readLine();
            String message = bufferedReader.readLine();
            bufferedReader.close();
            String response = "";
            if (users.containsKey(to)) {
                ArrayList<String> stringArrayList = users.get(to);
                if (stringArrayList == null) {
                    stringArrayList = new ArrayList<>();
                    users.put(to, stringArrayList);
                }
                stringArrayList.add(name + " -> " + message);
            } else {
                response = "no";
            }
            httpExchange.sendResponseHeaders(200, response.length());
            bufferedWriter.write(response);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpExchange.close();
        }
    }

    private static void handleReceive(HttpExchange httpExchange) {
        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));
        try {
            String name = bufferedReader.readLine();
            bufferedReader.close();
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList<String> stringArrayList = users.get(name);
            users.put(name, null);
            if (stringArrayList != null) {
                stringArrayList.stream().forEach(s -> {
                    stringBuffer.append(s);
                    stringBuffer.append("%%");
                });
            }
            String response = stringBuffer.toString();
            System.out.println(response);
            httpExchange.sendResponseHeaders(200, response.length());
            bufferedWriter.write(response);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpExchange.close();
        }
    }


    private static void handleConnect(HttpExchange httpExchange) {
        InputStream requestBody = httpExchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody));
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(responseBody));
        try {
            String s = bufferedReader.readLine();
            bufferedReader.close();
            String response = "connected";
            if (users.containsKey(s))
                response = "taken";
            else
                users.put(s, null);
            httpExchange.sendResponseHeaders(200, response.length());
            bufferedWriter.write(response);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpExchange.close();
        }

    }

}
