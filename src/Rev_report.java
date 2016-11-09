import java.util.*;
import java.io.Serializable;

/**
* A class which stores the revenue of one month.
*/ 
public class Rev_report implements Serializable {    
    private double totalRevenue;
    private List<Integer> menuItemIDs;
    private List<Integer> promoSetIDs;
	
    /**
    * Constructor.
    * Create a new revenue report.
    */
	public Rev_report() {
        menuItemIDs = new ArrayList<Integer>();
        promoSetIDs = new ArrayList<Integer>();
        totalRevenue = 0;
	}
    
    /**
    * Returns the current total revenue.
    * @return Current total revenue.
    */
    public double getTotalRevenue() {
        return totalRevenue;
    }
    
    /**
    * @return The list of ids of all menu item.
    */
    public List<Integer> getMenuItemIDs() {   
        return menuItemIDs;
    }
    
    /**
    * @return The list of ids of all promo set.
    */
    public List<Integer> getPromoSetIDs() {
        return promoSetIDs;
    }
	
    /**
    * Add an order to this report.
    * @param menuItemIDs The menu item ids which are going to be added.
    * @param promoSetIDs The set item ids which are going to be added.
    * @param totalRevenue The total revenue of this order.
    */
    public void addOrder(List<Integer> menuItemIDs, List<Integer> promoSetIDs, double totalRevenue) {
        this.menuItemIDs.addAll(menuItemIDs);
        this.promoSetIDs.addAll(promoSetIDs);
        this.totalRevenue += totalRevenue;
    }
    
    /**
    * Print the report details.
    * @param menu The class which contains all the menu id.
    * @param promoSet The class which contains all the promo id.
    */
    public void print(Menu menu, PromoSet promoSet) {
        System.out.println("Revenue report:");
        
        for (int id: getMenuItemIDs()) {
            System.out.println(menu.getMenuItem(id).toString());
        }
        
        for (int id: getPromoSetIDs()) {
            System.out.println(promoSet.getSetItem(id).toString());
        }    
        
        System.out.println("Total revenue this month: " + getTotalRevenue());
    }
}
