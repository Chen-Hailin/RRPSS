import java.util.*;
import java.text.SimpleDateFormat;
import java.io.Serializable;

class OrderList implements Serializable {
    private Map<Reservation, Order> orderList;

    private static OrderList instance = null;

    private OrderList(){};

    public static OrderList getInstance(){
        if(instance == null)
            instance = new OrderList();
        return instance;
    }

    public void setInstance() {
        instance = this;
    }

    public Map<Reservation, Order> getOrderList() {
        if (orderList == null)
            orderList = new HashMap<Reservation, Order> ();

        return orderList;
    }

    public Order getOrder(Reservation key) {
        return getOrderList().get(key);
    }

    public void removeOrder (Reservation reservation) {
        orderList.remove(reservation);
    }

    public void printOrder() {
        for (Map.Entry <Reservation, Order> entry : getOrderList().entrySet()) {
            entry.getValue().print(Menu.getInstance(), PromoSet.getInstance());
            System.out.println("########################");
        }
    }
}
