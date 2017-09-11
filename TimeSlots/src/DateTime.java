import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Anonymous on 20-Jul-17.
 */
public class DateTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter starting time (hh:mm AM/PM)");
        String dateStart = sc.nextLine();

        System.out.print("Enter ending time (hh:mm AM/PM)");
        String dateStop = sc.nextLine();

        int realstarttime = Integer.parseInt(dateStart.substring(0, 2));

        int timeslots = 0;

        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("h:mm a");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffHours = Math.abs(diff / (60 * 60*1000) % 24);
            System.out.print(diffHours + " hours");

            System.out.print("Enter time slots (in hrs)");
            timeslots = sc.nextInt();

            if (timeslots == 0)
                System.exit(0);
            else {
                int nextstep,temp=0;
                while (diffHours >= timeslots) {
                    nextstep=realstarttime+timeslots;
                   if(nextstep>12) {
                       System.out.println(realstarttime + " to " + (temp += timeslots));
                       realstarttime = temp;
                   }
                   else
                       System.out.println(realstarttime + " to " + (realstarttime += timeslots));
                    diffHours -= timeslots;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}