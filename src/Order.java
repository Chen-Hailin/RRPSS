import java.util.*;
import java.io.Serializable;

/**
* Store information of an order.
*/
public class Order implements Serializable {
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

    /**
    * Returns the reservation on this order.
    * @return The reservation object from this order.
    */ 
    public Reservation getReservation() {
        return reservation;
    }

    /**
    * Returns the list of promotion set by this order.
    * @return List of id of promotion set ordered.
    */
    public List<Integer> getPromotionSetIDs() {
        return promotionSetIDs;
    }

    /**
    * Returns the list of menu item. 
    * @return List of menu item id ordered by this order.
    */
    public List<Integer> getMenuItemIDs() {
        return menuItemIDs;
    }

    /**
    * Add an order from the promotion set id.
    * @param promotionSetID The id of the promotion set which is going to be added to the order.
    */
    public void addPromotionSet(Integer promotionSetID) {
        promotionSetIDs.add(promotionSetID);
    }

    /**
    * Add an order from the menu item id.
    * @param menuItemID the id of the menu that is going to be aded to the order.
    */
    public void addMenuItem(Integer menuItemID) {
        menuItemIDs.add(menuItemID);
    }

    /**
    * Remove a promotion set order.
    * @param promotionSetID The id of the set that wants to be removed.
    * @return False if the specified item is not in the order, otherwise Yes
    */
    public boolean removePromotionSet(Integer promotionSetID) {
        return promotionSetIDs.remove(promotionSetID);
    }

    /**
    * Remove a menu item order.
    * @param menuItemID the id of the menu that wants to be removed.
    * @return False if the specified item is not in the order, otherwise Yes
    */
    public boolean removeMenuItem(Integer menuItemID) {
        return menuItemIDs.remove(menuItemID);
    }
    
    /**
    * Print the order details.
    * The reservation, and all item ordered are listed out by this method.
    * @param menu The class which contains id of all menu item.
    * @param promoSet The class which contains id of all set item.
    */
    public void print(Menu menu, PromoSet promoSet) {
        getReservation().check();

        for (int id: getMenuItemIDs()) {
            System.out.println(menu.getMenuItem(id).toString());
        }

        for (int id: getPromotionSetIDs()) {
            if (promoSet.getSetItem(id) == null)
                continue;
            System.out.println(promoSet.getSetItem(id).toString());
        }
    }

    /**
    * Print the order details, calculate the total, then append to the report list.
    * @param menu The class which contains id of all menu items.
    * @param promoSet The class which contains id of all set items.
    * @param rev_rep_list The class which contains all the reports.
    */ 
    public void printInvoice(Menu menu, PromoSet promoSet, Rev_rep_list rev_rep_list) {
        print(menu, promoSet);

        double total = 0;
        for (int id: getMenuItemIDs()) {
            total += menu.getMenuItem(id).getItemPrice();
        }

        for (int id: getPromotionSetIDs()) {
            total += promoSet.getSetItem(id).getSetPrice();
        }
        
        System.out.println("Total: " + total);

        rev_rep_list.addRevReport(getMenuItemIDs(), getPromotionSetIDs(), total, getReservation().getArrivalTime());
    }
}
