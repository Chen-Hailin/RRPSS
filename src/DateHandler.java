import java.text.SimpleDateFormat;
import java.util.*;

/**
* Handle date operations in App class
*/
class DateHandler {
    /**
    * convert date into integer in format yyyyMMdda where a represent the AM/PM session
    * @param dateIn the date which going to be parsed
    * @return integer format of parsed date
    */
    public static Integer parseDatetoInteger (Date dateIn) throws Exception{
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        String date = ft.format(dateIn);
        ft = new SimpleDateFormat("a");
        if (isAMSession(dateIn)) date += "0";
        else if (isPMSession (dateIn)) date += "1";
        else return null;

        return Integer.parseInt(date);
    }

    /**
    * parse string in format d/M/yyyy H:m to date
    * @param date string format of the date
    * @return parsed string
    */
    public static Date readDate(String date) throws Exception{
        return new SimpleDateFormat("d/M/yyyy H:m").parse(date);
    }

    /**
    * check whether the date is in AM session or not
    * @param date The date which going to be checked
    * @return True if it is in AM Session, otherwise False
    */
    public static boolean isAMSession (Date date) throws Exception{
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new SimpleDateFormat("HH:mm:ss").parse("11:00:00"));
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new SimpleDateFormat("HH:mm:ss").parse("15:00:00"));

        Calendar cal3 = Calendar.getInstance();
        cal3.setTime(new SimpleDateFormat("HH:mm:ss").parse(new SimpleDateFormat("HH:mm:ss").format(date)));

        return cal3.getTime().after(cal1.getTime()) && cal3.getTime().before(cal2.getTime());
    }

    /**
    * check whether the date is in PM session or not
    * @param date The date which going to be checked
    * @return True if it is in PM Session, otherwise False
    */
    public static boolean isPMSession (Date date) throws Exception{
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new SimpleDateFormat("HH:mm:ss").parse("18:00:00"));
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new SimpleDateFormat("HH:mm:ss").parse("22:00:00"));

        Calendar cal3 = Calendar.getInstance();
        cal3.setTime(new SimpleDateFormat("HH:mm:ss").parse(new SimpleDateFormat("HH:mm:ss").format(date)));

        return cal3.getTime().after(cal1.getTime()) && cal3.getTime().before(cal2.getTime());
    }

    /**
    * get time now
    * @return current time in Date format
    */
    public static Date getTimeNow() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }
}
