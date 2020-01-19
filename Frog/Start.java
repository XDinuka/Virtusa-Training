import java.util.*;

public class Start {

    private static John john;

    public static void main(String[] args) {
        System.out.println("<<< John The Frog >>>");
        Scanner s = new Scanner(System.in);
        boolean repeat = true;
        john = new John();
        while (repeat) {

            System.out.println("What do you want John to do?\n" +
                    "1) Enter D to jump a distance.\n" +
                    "2) Enter T to jump a for a time.\n" +
                    "3) Enter N to get a new frog.\n" +
                    "4) Enter anything else to exit.");


            switch (getString(s)) {
                case "D":
                    System.out.println("How far do you want John to go?");
                    int d = getPositiveInteger(s);
                    john.jumpDistance(d);
                    System.out.println("John has jumped " + john.getDistance() + " meters in " + john.getTime() + " seconds.");
                    break;
                case "T":
                    System.out.println("For how long do you want John to jump?");
                    int t = getPositiveInteger(s);
                    john.jumpTime(t);
                    System.out.println("John has jumped " + john.getDistance() + " meters in " + john.getTime() + " seconds.");
                    break;
                case "N":
                    john = new John();
                    System.out.println("Got a new frog named John.");
                    break;
                default:
                    repeat = false;

            }


        }
    }

    private static int getPositiveInteger(Scanner scanner) {
        int i = 0;

        try {

            i = Integer.parseInt(scanner.nextLine());

            if (i <= 0)
                throw new IllegalArgumentException();

        } catch (NumberFormatException e) {
            System.out.println("Please enter a positive integer.");
            i = getPositiveInteger(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println("Please enter a positive integer.");
            i = getPositiveInteger(scanner);
        } catch (NoSuchElementException e) {
            System.out.println("Please enter a positive integer.");
            i = getPositiveInteger(scanner);
        } catch (IllegalStateException e) {
            scanner = new Scanner(System.in);
            i = getPositiveInteger(scanner);
        }

        return i;
    }

    private static String getString(Scanner scanner) {
        String s = null;

        try {
            s = scanner.nextLine();

        } catch (NoSuchElementException e) {
            System.out.println("Please enter a positive integer.");
            s = getString(scanner);
        } catch (IllegalStateException e) {
            scanner = new Scanner(System.in);
            s = getString(scanner);
        }

        return s;
    }


}