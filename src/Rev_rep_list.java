import java.util.*;
import java.io.Serializable;
import java.text.DateFormatSymbols;

public class Rev_rep_list implements Serializable {
    /**
    * List of revenue report from January to December.
    * e.g. reports[0] contains all orders from January.
    */
    private Rev_report[] reports;

    private static Rev_rep_list instance = null;
    
    //private constructor exist to defeat public instantiation, 
    private Rev_rep_list() {
        reports = new Rev_report[12];
    }
    
    //APP can use this to get the singleton reference
    public static Rev_rep_list getInstance(){
		if(instance == null)
			instance = new Rev_rep_list();
		return instance;
	}

    public void setInstance() {
		instance = this;
	}

    /**
    * Add an order to the revenue report
    * @param order Order that is going to be added
    */
    public void addRevReport(List<Integer> menuItemIDs, List<Integer> promoSetIDs, double total) {
        Date date = order.getReservation().getArrivalTime();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);

        reports[month].addOrder(menuItemIDs, promoSetIDs, total);
    }

    /**
    * Print the revenue report from a given range of time.
    * Month is given 0-based.
    * @param start The starting month.
    * @param end The ending month.
    */
    public void printReport(int start, int end, Menu menu, PromoSet promoSet) {
        for (int month = start; month <= end; month++) {
            System.out.println(new DateFormatSymbols().getMonths()[month - 1] + ": ");
            reports[month].print(menu, promoSet);
        }
    }

    /**
    * Print all the revenue report from the beginning to the end of month
    */
    public void printReport(Menu menu, PromoSet promoSet){
        printReport(0, 11, menu, promoSet);
    }
}
