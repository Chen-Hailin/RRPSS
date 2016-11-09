import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class TablesList implements Serializable{
	//when pass the 'date' argument, please ensure the format as YYYYMMDDS
	//Eg: 201603110 means 11th April 2016, AM session
	/**
	 * store the table status of different sessions
	 */
	private Map<Integer, Tables> tables_with_date = new HashMap<Integer, Tables>();
	/**
	 * store tables the restaurant currently have
	 */
	private List<Integer> all_tables = new ArrayList<Integer>();
	
	/**
	 * Singleton instance
	 */
    private static TablesList instance = null;
    /**
     * Private Constructor, defeat instantiation and initialize all_tables as told in instructions
     */
    private TablesList(){
    	for(int i = 0; i < 30; i++){
			if(i < 5)
				all_tables.add(10);
			else if(i < 10)
				all_tables.add(8);
			else if(i < 20)
				all_tables.add(4);
			else
				all_tables.add(2);
		}
    };
    //APP can use this to get the singleton reference
    /**
     * get the singleton instance
     * @return the TablesList instance
     */
    public static TablesList getInstance(){
		if(instance == null)
			instance = new TablesList();
		return instance;
	}

    /**
     * used for ensuring singleton after de-serialization 
     */
	public void setInstance() {
		instance = this;
	}

    /**
     * return the allocated table ID, if not application return -1
     * @param date the date-session that guests are arriving, 
     * @param pax the number of people having meal,
     * @param Desire_status eg "vacated", 
     * @param Target_status the status to be changed after the table is booked
     * @return int the table ID, if there's no table suitable, return -1
     */
	public int check_get(int date, int pax, String Desire_status, String Target_status){
		//if the date is not yet in the hash list, initialize one
		if(tables_with_date.get(new Integer(date)) == null)
			this.initialize(date);
		return tables_with_date.get(new Integer(date)).getTable(pax, Desire_status, Target_status);
	}

	/**
	 * change the status of certain table in a certain date
	 * @param date the date for the change
	 * @param ID the table ID
     * @param Target_status the status to be changed to
     */
	public void changeStatus(int date, int ID, String Target_status){
		tables_with_date.get(new Integer(date)).ChangeStatus(ID, Target_status);
	}

	/**
	 * remove all the out-dated tables info
     * @param today the current date-session
     */
	public void remove_old(int today){
		for(Integer date : tables_with_date.keySet()){
			if(date < today)
				tables_with_date.remove(date);
		}
	}
	/**
	 * Initialize Tables object for a new session
	 * @param date
	 */
	private void initialize(int date){
		tables_with_date.put(new Integer(date), new Tables(all_tables));
	}
	/**
	 * add tables with certain pax to restaurant
	 * @param quantity the quantity of this type of tables need to add 
	 * @param pax the pax of the new table
	 */
	public void addTable(int quantity, int pax){
		for(int i = 0; i < quantity; i++)
			all_tables.add(pax);
	}
	
}
