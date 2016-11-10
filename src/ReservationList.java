import java.util.*;
import java.text.SimpleDateFormat;
import java.io.Serializable;

class ReservationList implements Serializable {

	private List<Reservation> reservationList;

    private static ReservationList instance = null;

    private ReservationList(){};

    public static ReservationList getInstance(){
        if(instance == null)
            instance = new ReservationList();
        return instance;
    }

    public void setInstance() {
        instance = this;
    }


    public List<Reservation> getReservationList() {
        if (reservationList == null)
            reservationList = new ArrayList<Reservation> ();

        return reservationList;
    }

    public void addReservation(Date reservationDate, int numberOfPax, String name, String contactNumber, int tableID, TablesList tablesList)throws Exception{
    	getReservationList().add(new Reservation(reservationDate, numberOfPax, name, contactNumber, tableID, tablesList));
    	System.out.println("succeed in adding");
    }

    public Reservation getReservation(Date date, String contactNumber) throws Exception{
        for (Reservation rev : getReservationList()) {
            if (rev.getContactNumber().equals(contactNumber) &&
            DateHandler.parseDatetoInteger(rev.getArrivalTime()).equals(DateHandler.parseDatetoInteger(date)))
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

    public void removeReservation (Date date, String contactNumber, TablesList tablesList) throws Exception{
        Reservation tmp = getReservation (date, contactNumber);
        tablesList.changeStatus (DateHandler.parseDatetoInteger(date), tmp.getTableID(), "vacated");
        getReservationList().remove(getReservation (date, contactNumber));
    }

    public void removeExpiredReservation (Date date) {
        for (Iterator <Reservation> it = getReservationList().iterator(); it.hasNext();) {
            Reservation rev = it.next();
            if ((date.getTime() - rev.getArrivalTime().getTime()) / 1000 / 60 > 30) {
                it.remove();
            }
        }
    }

    public void printList(){
    	for(Reservation rev : getReservationList())
    		rev.check();
    }
}
