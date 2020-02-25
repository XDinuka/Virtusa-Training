import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {

    static Map<String, ArrayList<String>> users = new HashMap<>();


    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(5000), 0);
            httpServer.createContext("/connect", Server::handleConnect);
            httpServer.createContext("/send", Server::handleSend);
            httpServer.createContext("/receive", Server::handleReceive);
            httpServer.createContext("/list", Server::handleList);
            httpServer.createContext("/disconnect", Server::handleDisconnect);
            httpServer.start();
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
            users.put(name,null);
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
