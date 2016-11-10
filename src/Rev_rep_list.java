import java.util.*;
import java.io.Serializable;
import java.text.DateFormatSymbols;

/**
* Store the revenue reports of one year.
*/
public class Rev_rep_list implements Serializable {
    /**
    * List of revenue report from January to December.
    * e.g. reports[0] contains all orders from January.
    */
    private Rev_report[] reports;

    private static Rev_rep_list instance = null;

    /**
    * Private constructor exist to defeat public instantiation.
    */
    private Rev_rep_list() {
        reports = new Rev_report[12];
    }

    /**
    * APP can use this to get the singleton reference
    */
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
    * @param menuItemIDs List of menu item which is going to be added to the report.
    * @param promoSetIDs List of promo item which is going to be added to the report.
    * @param total The total price of the added items.
    * @param date The date of the order.
    */
    public void addRevReport(List<Integer> menuItemIDs, List<Integer> promoSetIDs, double total, Date date, Menu menu, PromoSet promoSet) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);

        if (reports[month] == null)
            reports[month] = new Rev_report();
        reports[month].print(menu, promoSet);
        reports[month].addOrder(menuItemIDs, promoSetIDs, total);
    }

    /**
    * Print the revenue report from a given range of time.
    * Month is given 0-based.
    * @param start The starting month.
    * @param end The ending month.
    * @param menu The class which contains all the menu id.
    * @param promoSet The class which contains all the promoSet id.
    */
    public void printReport(int start, int end, Menu menu, PromoSet promoSet) {
        for (int month = start; month <= end; month++) {
            System.out.println(new DateFormatSymbols().getMonths()[month] + ": ");
            if (reports[month] == null)
                reports[month] = new Rev_report();
            reports[month].print(menu, promoSet);
        }
    }

    /**
    * Print all the revenue report from the beginning to the end of month.    
    * @param menu The class which contains all the menu id.
    * @param promoSet The class which contains all the promoSet id.
    */
    public void printReport(Menu menu, PromoSet promoSet){
        printReport(0, 11, menu, promoSet);
    }
}
