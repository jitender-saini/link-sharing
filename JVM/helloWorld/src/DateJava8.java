import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

public class DateJava8 {
public static void main(String[] args) {
    LocalDateTime date = LocalDateTime.now();
//    System.out.println("DAY_OF_WEEK : "+date.get(ChronoField.DAY_OF_WEEK));
//    System.out.println("DAY_OF_YEAR : "+date.get(ChronoField.DAY_OF_YEAR));
//    System.out.println("DAY_OF_MONTH : "+date.get(ChronoField.DAY_OF_MONTH));
//    System.out.println("HOUR_OF_DAY : "+date.get(ChronoField.HOUR_OF_DAY));
//    System.out.println("MINUTE_OF_DAY : "+date.get(ChronoField.MINUTE_OF_DAY));
//    System.out.println("AMPM_OF_DAY : "+date.get(ChronoField.AMPM_OF_DAY));
//    System.out.println("SECOND_OF_DAY : "+date.get(ChronoField.SECOND_OF_DAY));
//    System.out.println("MICRO_OF_SECOND : "+date.get(ChronoField.MICRO_OF_SECOND));
    System.out.println("Format: " + date.format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));

//    Date date = new Date();
//    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//    String strDate= formatter.format(date);
//    System.out.println("str date"+strDate);


//    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//    try {
//        Date date = formatter.parse("31/02/2020");
//        System.out.println("Date is: "+date);
//    } catch (ParseException e) {
//        e.printStackTrace();
//    }




}
//    enum Month
//    {
//        JANUARY(1), FEBRUARY, MARCH, APRIL, MAY, JUNE,
//        JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
//    }


}
