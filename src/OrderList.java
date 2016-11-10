import java.util.*;
import java.text.SimpleDateFormat;
import java.io.Serializable;

/**
* Stores the list of orders
*/
public class OrderList implements Serializable {
    private Map<Reservation, Order> orderList;

    private static OrderList instance = null;

	//Exist only to defeat instantiation
    private OrderList(){};

    /**
    * APP can use this to get the singleton reference
    */
    public static OrderList getInstance(){
        if(instance == null)
            instance = new OrderList();
        return instance;
    }

	/**
	* Used to update the instance.
	*/
    public void setInstance() {
        instance = this;
    }
    /**
     * add an order into orderList
     * @param staff the staff handling this order
     * @param currentReservation the reservation associated with this order
     */
    public void addOrder(Staff staff, Reservation currentReservation){
    	this.getOrderList().put(currentReservation, new Order(staff, currentReservation));
    }
	/**
	* @return A hash map which map a reservation to an order.
	*/
    public Map<Reservation, Order> getOrderList() {
        if (orderList == null)
            orderList = new HashMap<Reservation, Order> ();

        return orderList;
    }

	/**
	* Get an order using reservation as the key.
	* @param key The key to identify the order.
	* @return The queried order.
	*/
    public Order getOrder(Reservation key) {
        return getOrderList().get(key);
    }

	/**
	* Remove an order from the list.
	* @param reservation The reservation which made the order.
	*/
    public void removeOrder (Reservation reservation) {
        orderList.remove(reservation);
    }

	/**
	* Print all available orders.
	*/
    public void printOrder() {
        for (Map.Entry <Reservation, Order> entry : getOrderList().entrySet()) {
            entry.getValue().print(Menu.getInstance(), PromoSet.getInstance());
            System.out.println("########################");
        }
    }
}
