import java.util.Calendar;
import java.text.DateFormat;
import java.util.*;

public class Date {
//      static void date() {
//        long cutterTime = System.currentTimeMillis();
//        java.util.Date date1 = new java.util.Date();
//        java.util.Date date2 = new java.util.Date();
//        Calendar cal =Calendar.getInstance();
//        cal.set(Calendar.YEAR,2018);
//        cal.set(Calendar.MONTH,11);
//        int year= cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH);
//        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
//        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
//        int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
//        System.out.println(cutterTime);
//        System.out.println(date1);
//        System.out.println(date2);
//        System.out.println(date1==date2);
//        System.out.println(cal);
//        System.out.println(cal.getTime());
//        System.out.println(year);
//        System.out.println(month);
//        System.out.println(dayOfMonth);
//        System.out.println(dayOfWeek);
//        System.out.println("monday"+Calendar.FRIDAY);
//        System.out.println("dayOfYear "+dayOfYear);
//
// }
    public static void main(String[] args) throws Exception {
        Date d1 = new Date();
        System.out.println("today is "+ d1.toString());
        Locale locItalian = new Locale("it","ch");
        DateFormat df = DateFormat.getDateInstance (DateFormat.FULL, locItalian);
        System.out.println("today is in Italian Language  in Switzerland Format : "+ df.format(d1));
    }
}
