import java.util.*;
import java.io.Serializable;

public class Rev_rep_list implements Serializable {

    //Exist only to defeat instantiation
    private static Rev_rep_list instance = null;

	//APP can use this to get the singleton reference
    public Rev_rep_list() {
        reports = new Rev_report[12];
    }

    public static Rev_rep_list getInstance(){
		if(instance == null)
			instance = new Rev_rep_list();
		return instance;
	}

    public void setInstance() {
        instance = this;
    }

    /**
    * List of revenue report from January to December.
    * e.g. reports[0] contains all orders from January.
    */
    private Rev_report[] reports;

    /**
    * Constructor.
    */

    /**
    * Add an order to the revenue report
    * @param order Order that is going to be added
    */
    public void addRevReport(Order order, double total) {
        Date date = order.getReservation().getArrivalTime();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);

        reports[month].addOrder(order, total);
    }

    /**
    * Print the revenue report from a given range of time.
    * @param start The starting month.
    * @param end The ending month.
    */
    public void printReport(int start, int end) {
        if (start <= 0 && 0 <= end) { System.out.println("Jan:"); reports[0].print(); }
        if (start <= 1 && 1 <= end) { System.out.println("Feb:"); reports[1].print(); }
        if (start <= 2 && 2 <= end) { System.out.println("Mar:"); reports[2].print(); }
        if (start <= 3 && 3 <= end) { System.out.println("Apr:"); reports[3].print(); }
        if (start <= 4 && 4 <= end) { System.out.println("May:"); reports[4].print(); }
        if (start <= 5 && 5 <= end) { System.out.println("Jun:"); reports[5].print(); }
        if (start <= 6 && 6 <= end) { System.out.println("Jul:"); reports[6].print(); }
        if (start <= 7 && 7 <= end) { System.out.println("Aug:"); reports[7].print(); }
        if (start <= 8 && 8 <= end) { System.out.println("Sep:"); reports[8].print(); }
        if (start <= 9 && 9 <= end) { System.out.println("Oct:"); reports[9].print(); }
        if (start <= 10 && 10 <= end) { System.out.println("Nov:"); reports[10].print(); }
        if (start <= 11 && 11 <= end) { System.out.println("Dec:"); reports[11].print(); }
    }

    /**
    * Print all the revenue report from the beginning to the end of month
    */
    public void printReport(){
        printReport(0, 11);
    }
}
