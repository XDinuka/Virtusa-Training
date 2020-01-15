import java.util.Scanner;

public class Start {

    private static John john;

    public static void main(String[] args) {
        System.out.println("<<< John The Frog >>>");
        Scanner s = new Scanner(System.in);
        boolean repeat = true;
        john = new John();
        while(repeat){
            System.out.println("What do you want John to do?");
            System.out.println("1) Enter D to jump a distance.");
            System.out.println("2) Enter T to jump a for a time.");
            System.out.println("3) Enter N to get a new frog.");
            System.out.println("4) Enter anything else to exit.");
            
            switch(s.next()){
                case "D":
                    System.out.println("How far do you want John to go?");
                    int d = s.nextInt();
                    john.jumpDistance(d);
                    System.out.println("John has jumped "+john.getDistance()+" meters in "+john.getTime()+" seconds.");
                break;
                case "T":
                    System.out.println("For how long do you want John to jump?");
                    int t = s.nextInt();
                    john.jumpDistance(t);
                    System.out.println("John has jumped "+john.getDistance()+" meters in "+john.getTime()+" seconds.");
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
}