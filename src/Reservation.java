import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.Serializable;

/**
* Stores the information of a reservation.
*/
public class Reservation implements Serializable {
    private Date arrivalTime;
    private int numberOfPax;
    private String name;
    private String contactNumber;
    private int tableID;
    private TablesList tableslist;

    /**
    * Constructor.
    * Create a new reservation with the information provided, and set the reserved table to "reserved".
    * Reservation is uniquely identified by the contact number.
    * @param arrivalTime The arrival time of the reservation.
    * @param numberOfPax The number of pax of the reservation.
    * @param name The name of the person who made this reservation.
    * @param contactNumber The contact number of the person who reserved.
    * @param tableID The reserved table ID.
    * @param tableslist The class which contains information of all tables.
    */
    public Reservation(Date arrivalTime, int numberOfPax, String name, String contactNumber, int tableID, TablesList tableslist) throws Exception {
        this.arrivalTime     = arrivalTime;
        this.numberOfPax     = numberOfPax;
        this.name            = name;
        this.contactNumber   = contactNumber;
        this.tableID         = tableID;
        this.tableslist		 = tableslist;

        this.tableslist.changeStatus(DateHandler.parseDatetoInteger(arrivalTime), tableID, "reserved");
    }

    /**
    * @return The arrival time of this reservation.
    */
    public Date getArrivalTime() {
        return arrivalTime;
    }
    
    /**
    * @return The number of pax.
    */
    public int getNumberOfPax() {
        return numberOfPax;
    }

    /**
    * @return The name of person who reserved this reservation.
    */
    public String getName() {
        return name;
    }

    /**
    * @return The contact number of the person.
    */ 
    public String getContactNumber() {
        return contactNumber;
    }

    /**
    * @return The id of the reserved table.
    */
    public int getTableID() {
        return tableID;
    }

    /**
    * Indicates whether other reservation is equal to this reservation.
    * @param o The object to be compared.
    * @return True if they are equal. False otherwise.
    */
    public boolean equals (Object o) {
        if (o instanceof Reservation) {
            Reservation other = (Reservation) o;
            if (getArrivalTime().equals(other.getArrivalTime()) == false) return false;
            if (getNumberOfPax()    != other.getNumberOfPax()) return false;
            if (getName().equals(other.getName()) == false) return false;
            if (getContactNumber().equals(other.getContactNumber()) == false) return false;
            if (getTableID()        != other.getTableID()) return false;
            return true;
        }
        return false;
    }

    /**
    * Hash this class into an integer.
    * @return The hashed class.
    */
    public int hashCode() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        String date = ft.format(arrivalTime);
        ft = new SimpleDateFormat("a");
        
        if (ft.format(arrivalTime) == "AM") date.concat("0");
        else date.concat("1");
        
        return (Integer.parseInt(contactNumber) * contactNumber.length() +
            name.hashCode() * (contactNumber.length() + name.length()) +
            Integer.parseInt(date)) * 100 + tableID;
    }

    /**
    * Check the reservation status.
    */
    public void check() {
        SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm a");
        System.out.println("Your arrival time: " + ft.format(getArrivalTime()));
        System.out.println("Name: " + getName());
        System.out.println("Number of people: " + getNumberOfPax());
        System.out.println("Contact number: " + getContactNumber());
        System.out.println("Table number: " + getTableID());
    }
}
