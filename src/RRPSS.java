import java.util.*;
import java.text.SimpleDateFormat;

class RRPSS {
    private IOFileHandler io = new IOFileHandler();
    private Map<Reservation, Order> orderList;
    private List<Reservation> reservationList;

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

    public List<Reservation> getReservationList() {
        if (reservationList == null)
            reservationList = new ArrayList<Reservation> ();

        return reservationList;
    }

    public Reservation getReservation(Date date, String contactNumber) {
        for (Reservation rev : getReservationList()) {
            if (rev.getContactNumber().equals(contactNumber) &&
            parseDatetoInteger(rev.getArrivalTime()).equals(parseDatetoInteger(date)))
                return rev;
        }
        return null;
    }

    public void checkReservation (String contactNumber) {
        for (Reservation rev : getReservationList()) {
            if (rev.getContactNumber().equals(contactNumber)) {
                System.out.println ("########################");
                rev.check();
            }
        }
        System.out.println ("########################");
    }

    public void removeReservation (Date date, String contactNumber) {
        Reservation tmp = getReservation (date, contactNumber);
        TablesList.getInstance().changeStatus (parseDatetoInteger(date), tmp.getTableID(), "vacated");
        getReservationList().remove(getReservation (date, contactNumber));
    }


    void loadData() {
        try {
            Rev_rep_list currentRev = (Rev_rep_list) io.readObj ("revenue_list.ser");
            currentRev.setInstance();
        } catch (NullPointerException ioException) {}

        try {
            PromoSet promo = (PromoSet) io.readObj ("promo_set.ser");
            promo.setInstance();
        } catch (NullPointerException ioException) {}

        try {
            Menu menu = (Menu) io.readObj ("menu.ser");
            menu.setInstance();
        } catch (NullPointerException ioException) {}

        try {
            TablesList tableList = (TablesList) io.readObj ("table_list.ser");
            tableList.setInstance();
        } catch (NullPointerException ioException) {}

        try {
            orderList = (HashMap<Reservation, Order>) io.readObj ("order_list.ser");
        } catch (NullPointerException ioException) {}

        try {
            reservationList = (ArrayList<Reservation>) io.readObj ("reservation_list.ser");
        } catch (NullPointerException ioException) {}

    }

    void storeData() {
        io.writeObj ("revenue_list.ser", Rev_rep_list.getInstance());
        io.writeObj ("promo_set.ser", PromoSet.getInstance());
        io.writeObj ("menu.ser", Menu.getInstance());
        io.writeObj ("table_list.ser", TablesList.getInstance());
        io.writeObj ("order_list.ser", this.orderList);
        io.writeObj ("reservation_list.ser", this.reservationList);
    }

    private Integer parseDatetoInteger (Date dateIn) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        String date = ft.format(dateIn);
        ft = new SimpleDateFormat("a");
        if (ft.format(dateIn) == "AM") date.concat("0");
        else date.concat("1");

        return Integer.parseInt(date);
    }

}
