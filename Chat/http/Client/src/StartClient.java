import sun.net.www.http.HttpClient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class StartClient {

    // connect localhost:5000 as dinuka

    private static String username;
    private static String serverUrl;
    private static boolean isConnected = false;

    public static void main(String[] args) {

        System.out.println("Welcome");
        Scanner scanner = new Scanner(System.in);


        while (true) {
            try {
                Thread.sleep(1000);
                String s = scanner.nextLine();
                if (s.matches("connect [a-z0-9:.]+ as [a-z0-9]+")) {
                    if (isConnected) {
                        System.out.println("You're already connected as " + username);
                    } else {
                        String[] split = s.split(" ", 4);
                        serverUrl = split[1];
                        username = split[3];
                        sendConnect();
                    }
                } else if (s.equals("list") && isConnected) {
                    sendList();
                } else if (s.matches("send .* -> .*") && isConnected) {
                    String[] substring = s.substring(5).split(" -> ");
                    sendMessage(substring[0], substring[1]);
                } else if (s.equals("quit") && isConnected) {
                    if (isConnected)
                        sendDisconnect();
                    else
                        System.out.println("You're not connected");
                    break;
                } else if (isConnected) {
                    System.out.println("Invalid Input");
                } else {
                    System.out.println("You're not connected");
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

    static class MessageChecker extends Thread {
        public void run() {
            while (isConnected) {
                try {
                    URL url = new URL("http://" + serverUrl + "/receive");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setDoOutput(true);
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
                    bufferedWriter.write(username);
                    bufferedWriter.close();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String s = bufferedReader.readLine();
                    if (!s.equals("no message"))
                        System.out.print(s.replaceAll("%%", System.lineSeparator()));
                } catch (Exception e) {
                }
            }
        }
    }

    private static void sendConnect() {
        if (!isConnected) {
            try {
                URL url = new URL("http://" + serverUrl + "/connect");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
                bufferedWriter.write(username);
                bufferedWriter.close();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String s = bufferedReader.readLine();
                if (s.equals("taken")) {
                    username = null;
                    isConnected = false;
                    System.out.println("Username taken. Try another username.");
                } else {
                    isConnected = true;
                    System.out.println("Connected");
                    new MessageChecker().start();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sendList() {
        try {
            URL url = new URL("http://" + serverUrl + "/list");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
            bufferedWriter.write(username);
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String s = bufferedReader.readLine();
            if (s.isEmpty())
                System.out.println("No Users");
            else
                System.out.print(s.replaceAll("%%", System.lineSeparator()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage(String message, String toUser) {
        try {
            URL url = new URL("http://" + serverUrl + "/send");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.write(toUser);
            bufferedWriter.newLine();
            bufferedWriter.write(message);
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String s = bufferedReader.readLine();
            if ("no".equals(s)) {
                System.out.println("No such user");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendDisconnect() {
        try {
            URL url = new URL("http://" + serverUrl + "/disconnect");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
            bufferedWriter.write(username);
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String s = bufferedReader.readLine();
            System.out.println(s);
            if (s.equals("Disconnected")) {
                isConnected = false;
                username = null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
