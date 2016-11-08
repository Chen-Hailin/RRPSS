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
    * Print the order details (table number, timestamp, etc)
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

        rev_rep_list.addRevReport(getMenuItemIDs(), getPromotionSetIDs(), total, getReservation().getArrivalTime());
    }
}
