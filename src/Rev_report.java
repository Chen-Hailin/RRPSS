import java.util.*;
import java.io.Serializable;

public class Rev_report implements Serializable {    
    private double totalRevenue;
    private List<Integer> menuItemIDs;
    private List<Integer> promoSetIDs;
	
	public Rev_report() {
        menuItemIDs = new ArrayList<Integer>();
        promoSetIDs = new ArrayList<Integer>();
        totalRevenue = 0;
	}
    
    public double getTotalRevenue() {
        return totalRevenue;
    }
    
    public List<Integer> getMenuItemIDs() {   
        return menuItemIDs;
    }
    
    public List<Integer> getPromoSetIDs() {
        return promoSetIDs;
    }
	
    /**
    * Add an order to this report.
    * @param order The order going to be added.
    * @param totalRevenue The total revenue of this order.
    */
    public void addOrder(List<Integer> menuItemIDs, List<Integer> promoSetIDs, double totalRevenue) {
        this.menuItemIDs.addAll(menuItemIDs);
        this.promoSetIDs.addAll(promoSetIDs);
        this.totalRevenue += totalRevenue;
    }
    
    /**
    * Print the report details.
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
