import java.util.Scanner;
import java.util.TimeZone;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Timezone{

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Year : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Month : ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Date : ");
        int date = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Hour(24H) : ");
        int hour = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Minute : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Second : ");
        int second = Integer.parseInt(scanner.nextLine());

        scanner.close();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DATE, date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println("UTC : "+sdf.format(calendar.getTime()));    

        sdf.setTimeZone(TimeZone.getTimeZone("PST"));
        System.out.println("PST : "+sdf.format(calendar.getTime()));    

    }


}