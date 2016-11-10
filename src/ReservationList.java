import java.util.*;
import java.text.SimpleDateFormat;
import java.io.Serializable;

/**
* Stores the list of reservation.
*/
class ReservationList implements Serializable {

	private List<Reservation> reservationList;

    private static ReservationList instance = null;

	
	//Exist only to defeat instantiation
    private ReservationList(){};
	
    /**
    * APP can use this to get the singleton reference
    */
    public static ReservationList getInstance(){
        if(instance == null)
            instance = new ReservationList();
        return instance;
    }

	/**
	* Used to update the instance.
	*/ 
    public void setInstance() {
        instance = this;
    }

	/**
	* @return The reservation list.
	*/ 
    public List<Reservation> getReservationList() {
        if (reservationList == null)
            reservationList = new ArrayList<Reservation> ();

        return reservationList;
    }

	/**
	* Add a new reservation to the list.
	* @param reservationDate The date when the reservation is made.
	* @param numberOfPax Number of Pax for this reservation.
	* @param name The person name who made this reservation.
	* @param contactNumber The contact number of the person who made the reservation.
	* @param tableID The id of the reserved tableID.
	* @param tablesList The class which stores all the tables list.	
	*/ 
    public void addReservation(Date reservationDate, int numberOfPax, String name, String contactNumber, int tableID, TablesList tablesList)throws Exception{
    	getReservationList().add(new Reservation(reservationDate, numberOfPax, name, contactNumber, tableID, tablesList));
    	System.out.println("succeed in adding");
    }

	/**
	* Get a certain reservation from date and contact number.
	* @param date The date when the reservation is made.
	* @param contactNumber The contact number of person who made the reservation.
	*/ 
    public Reservation getReservation(Date date, String contactNumber) throws Exception{
        for (Reservation rev : getReservationList()) {
            if (rev.getContactNumber().equals(contactNumber) &&
            DateHandler.parseDatetoInteger(rev.getArrivalTime()).equals(DateHandler.parseDatetoInteger(date)))
                return rev;
        }
        return null;
    }

	/**
	* Print the status of the reservation from a certain person.
	* @param contactNumber The contact number of the person who made the reservation.
	*/ 
    public void checkReservation (String contactNumber) {
        for (Reservation rev : getReservationList()) {
            if (rev.getContactNumber().equals(contactNumber)) {
                System.out.println ("########################");
                rev.check();
            }
        }
        System.out.println ("########################");
    }

	/**
	* Remove a reservation from the list.
	* Reservation is uniquely identified by date and contact number.
	* @param date The date when the reservation is made.
	* @param contactNumber The contactNumber of the person who made the reservation.
	* @param tablesList The class which contains all tables list.
	*/
    public void removeReservation (Date date, String contactNumber, TablesList tablesList) throws Exception{
        Reservation tmp = getReservation (date, contactNumber);
        tablesList.changeStatus (DateHandler.parseDatetoInteger(date), tmp.getTableID(), "vacated");
        getReservationList().remove(getReservation (date, contactNumber));
    }

	/**
	* Remove a reservation when it is expired.
	* A reservation is expired if the person has not come after 30 minutes from the reserved date.
	* @param date Current date.
	*/
    public void removeExpiredReservation (Date date) {
        for (Iterator <Reservation> it = getReservationList().iterator(); it.hasNext();) {
            Reservation rev = it.next();
            if ((date.getTime() - rev.getArrivalTime().getTime()) / 1000 / 60 > 30) {
                it.remove();
            }
        }
    }
}
