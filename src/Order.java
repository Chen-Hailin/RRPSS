import java.util.ArrayList;

/**
* Store information of an order.
*/
class Order implements Serializable {
    private Reservation reservation;
    private Staff staff;
    private List<int> promotionSetIDs;
    private List<int> menuItemIDs;
    
    /**
    * Constructor.
    * Create a new order
    * @param staff The staff who created this order
    * @param reservation The reservation which made this order
    */
    public Order(Staff staff, Reservation reservation) {
        this.staff          = staff;
        this.reservation    = reservation;
        promotionSetIDs     = new ArrayList<int>();
        menuItemIDs         = new ArrayList<int>();
    }
    
    public Reservation getReservation() {
        return reservation;
    }
    
    public List<int> getPromotionSetIDs() {
        return promotionSetIDs;
    }
    
    public List<int> getMenuItemIDs() {
        return menuItemIDs;
    }
    
    /**
    * Add an order from the promotion set id.
    */
    public void addPromotionSet(int promotionSetID) {
        promotionSetIDs.add(promotionSetID);
    }   
    
    /**
    * Add an order from the menu item id.
    */
    public void addMenuItem(int menuItemID) {
        menuItemIDs.add(menuItemID);
    }
    
    /**
    * Remove a promotion set order.
    * @return False if the specified item is not in the order, otherwise Yes
    */
    public boolean removePromotionSet(int promotionSetID) {
        return promotionSetIDs.remove(promotionSetID);
    }
    
    /**
    * Remove a menu item order.
    * @return False if the specified item is not in the order, otherwise Yes
    */
    public boolean removeMenuItem(int menuItemID) {
        return menuItemIDs.remove(menuItemID);
    }
    
    public void print() {
        getReservation.check();
    }
    
    /**
    * Print the order details (table number, timestamp, etc).    
    */
    public void printInvoice() {        
        print();
        
        double total = 0;
        for (int id: getMenuItemIDs()) {
            total += Menu.getMenuItem().itemPrice;
        }
        
        for (int id: getPromotionSetIDs()) {
            total += PromoSet.getSetItem().setPrice;
        }
        
        Rev_rep_list.addRevReport(this, total);
    }
}   