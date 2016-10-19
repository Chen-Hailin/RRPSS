import java.util.ArrayList;

/**
* Store information of an order.
*/

class Order {
    private Reservation reservation;
    private Staff staff;
    private List<PromotionSet> promotionSets;    
    private List<MenuItem> menuItems;
    
    /**
    * Constructor.
    * Create a new order
    * @param staff The staff who created this order
    * @param reservation The reservation which made this order
    */
    public Order(Staff staff, Reservation reservation) {
        this.staff          = staff;
        this.reservation    = reservation;
        promotionSets   = new ArrayList<PromotionSet>();
        menuItems       = new ArrayList<MenuItem>();
    }
    
    /**
    * Add an order from the promotion sets.
    */
    public void addOrder(PromotionSet promotionSet) {
        promotionSets.add(promotionSet);
    }   
    
    /**
    * Add an order from the menu items.
    */
    public void addOrder(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
    
    /**
    * Remove a promotion set order.
    * @return False if the specified item is not in the order, otherwise Yes
    */
    public boolean removeOrder(PromotionSet promotionSet) {
        return promotionSets.remove(promotionSet);
    }
    
    /**
    * Remove a menu item order.
    * @return False if the specified item is not in the order, otherwise Yes
    */
    public boolean removeOrder(MenuItem menuItem) {
        return menuItems.remove(menuItem);
    }
    
    public void printInvoice() {
    
    }
}