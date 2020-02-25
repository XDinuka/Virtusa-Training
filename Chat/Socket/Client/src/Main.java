import pojo.InitMessage;

import java.util.Scanner;

public class Main {
    public static Scanner scanner;

    public static void main(String[] args) {

        System.out.println("Welcome");

        scanner = new Scanner(System.in);

        start();

    }

    public static void start() {



        String s = scanner.nextLine();


        if (s.equals("exit")) {
            System.out.println("Bye");
        } else if (s.startsWith("connect to")) {
            try {
                String[] split = s.split(" ");
                String ip = split[2];
                String name = split[4];

                String[] split1 = ip.split(":");

                ip = split1[0];
                Integer port = Integer.parseInt(split1[1]);


                ClientInitializer.initialize(ip, port, new InitMessage(name));


            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Enter a valid input");
                start();
            }
        } else {
            System.out.println("Enter a valid input");
            start();
        }
    }
}