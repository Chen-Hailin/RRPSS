import java.text.SimpleDateFormat;
import java.util.*;

class DateHandler {
    public static Integer parseDatetoInteger (Date dateIn) throws Exception{
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        String date = ft.format(dateIn);
        ft = new SimpleDateFormat("a");
        if (isAMSession(dateIn)) date += "0";
        else if (isPMSession (dateIn)) date += "1";
        else return null;

        return Integer.parseInt(date);
    }

    public static boolean isAMSession (Date date) throws Exception{
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new SimpleDateFormat("HH:mm:ss").parse("11:00:00"));
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new SimpleDateFormat("HH:mm:ss").parse("15:00:00"));

        Calendar cal3 = Calendar.getInstance();
        cal3.setTime(new SimpleDateFormat("HH:mm:ss").parse(new SimpleDateFormat("HH:mm:ss").format(date)));

        return cal3.getTime().after(cal1.getTime()) && cal3.getTime().before(cal2.getTime());
    }

    public static boolean isPMSession (Date date) throws Exception{
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new SimpleDateFormat("HH:mm:ss").parse("18:00:00"));
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new SimpleDateFormat("HH:mm:ss").parse("22:00:00"));

        Calendar cal3 = Calendar.getInstance();
        cal3.setTime(new SimpleDateFormat("HH:mm:ss").parse(new SimpleDateFormat("HH:mm:ss").format(date)));

        return cal3.getTime().after(cal1.getTime()) && cal3.getTime().before(cal2.getTime());
    }

    public static Date getTimeNow() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }
}
