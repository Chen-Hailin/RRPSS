import java.util.*;
import java.text.SimpleDateFormat;

class RRPSS_IO {
    private static IOFileHandler io = new IOFileHandler();

    public static void loadData() {
        try {
            Rev_rep_list currentRev = (Rev_rep_list) io.readObj ("revenue_list.ser");
            currentRev.setInstance();
        } catch (NullPointerException ioException) {}

        try {
            Menu menu = (Menu) io.readObj ("menu.ser");
            menu.setInstance();
        } catch (NullPointerException ioException) {}

        try {
            PromoSet promo = (PromoSet) io.readObj ("promo_set.ser");
            promo.setInstance();
        } catch (NullPointerException ioException) {}

        try {
            TablesList tableList = (TablesList) io.readObj ("table_list.ser");
            tableList.setInstance();
        } catch (NullPointerException ioException) {}

        try {
            OrderList orderList = (OrderList) io.readObj ("order_list.ser");
            orderList.setInstance();
        } catch (NullPointerException ioException) {}

        try {
            ReservationList reservationList = (ReservationList) io.readObj ("reservation_list.ser");
            reservationList.setInstance();
        } catch (NullPointerException ioException) {}

        try {
            StaticIDHandler maxID = (StaticIDHandler) io.readObj ("max_id.ser");
//            System.out.println(maxID == null);
            maxID.setInstance();
//            System.out.println(maxID.getMaxSetID());
        } catch (NullPointerException ioException) {}
    }

    public static void storeData() {
        io.writeObj ("revenue_list.ser", Rev_rep_list.getInstance());
        io.writeObj ("promo_set.ser", PromoSet.getInstance());
        io.writeObj ("menu.ser", Menu.getInstance());
        io.writeObj ("table_list.ser", TablesList.getInstance());
        io.writeObj ("order_list.ser", OrderList.getInstance());
        io.writeObj ("reservation_list.ser", ReservationList.getInstance());
        io.writeObj ("max_id.ser", StaticIDHandler.getInstance());
    }

}
