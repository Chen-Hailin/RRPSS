import java.util.Date;
import java.text.SimpleDateFormat;

/**
* Stores the information of a reservation.
*/
class Reservation {
    private Date arrivalTime;
    private int numberOfPax;
    private String name;
    private String contactNumber;
    private Table table;
    
    /**
    * Constructor.
    * Create a new reservation with the information provided, and set the reserved table to "reserved".
    * Reservation is uniquely identified by the contact number.
    */
    public Reservation(Date arrivalTime, int numberOfPax, String name, String contactNumber, Table table) {
        this.arrivalTime     = arrivalTime;
        this.numberOfPax     = numberOfPax;
        this.name            = name;
        this.contactNumber   = contactNumber;
        this.table           = table;
        
        table.setStatus("reserved");
    }
    
    private Date getArrivalTime() {
        return arrivalTime;
    }
    
    public int getNumberOfPax() {
        return numberOfPax;
    }
    
    public String getName() {
        return name;
    }
    
    public String getContactNumber() {
        return contactNumber;
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
        System.out.println("Table number: " + table.getTableNumber());
    }
}