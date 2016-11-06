import java.util.*;
import java.io.Serializable;

/**
* Store information of an order.
*/
class Order implements Serializable {
    private Reservation reservation;
    private Staff staff;
    private List<Integer> promotionSetIDs;
    private List<Integer> menuItemIDs;
    
    /**
    * Constructor.
    * Create a new order
    * @param staff The staff who created this order
    * @param reservation The reservation which made this order
    */
    public Order(Staff staff, Reservation reservation) {
        this.staff          = staff;
        this.reservation    = reservation;
        promotionSetIDs     = new ArrayList<Integer>();
        menuItemIDs         = new ArrayList<Integer>();
    }
    
    public Reservation getReservation() {
        return reservation;
    }
    
    public List<Integer> getPromotionSetIDs() {
        return promotionSetIDs;
    }
    
    public List<Integer> getMenuItemIDs() {
        return menuItemIDs;
    }
    
    /**
    * Add an order from the promotion set id.
    */
    public void addPromotionSet(Integer promotionSetID) {
        promotionSetIDs.add(promotionSetID);
    }   
    
    /**
    * Add an order from the menu item id.
    */
    public void addMenuItem(Integer menuItemID) {
        menuItemIDs.add(menuItemID);
    }
    
    /**
    * Remove a promotion set order.
    * @return False if the specified item is not in the order, otherwise Yes
    */
    public boolean removePromotionSet(Integer promotionSetID) {
        return promotionSetIDs.remove(promotionSetID);
    }
    
    /**
    * Remove a menu item order.
    * @return False if the specified item is not in the order, otherwise Yes
    */
    public boolean removeMenuItem(Integer menuItemID) {
        return menuItemIDs.remove(menuItemID);
    }
    
    public void print() {
        getReservation().check();
    }
    
    /**
    * Print the order details (table number, timestamp, etc).    
    */
    public void printInvoice() {        
        print();
        
        double total = 0;
        for (int id: getMenuItemIDs()) {
            total += Menu.getInstance().getMenuItem(id).getItemPrice();
        }
        
        for (int id: getPromotionSetIDs()) {
            total += PromoSet.getInstance().getSetItem(id).getSetPrice();
        }
        
        Rev_rep_list.getInstance().addRevReport(this, total);
    }
}   