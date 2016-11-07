import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

public class TablesList implements Serializable{
	//when pass the 'date' argument, please ensure the format as YYYYMMDDS
	//Eg: 201603110 means 11th April 2016, AM session
	private Map<Integer, Tables> tables_with_date = new HashMap<Integer, Tables>();

	
    private static TablesList instance = null;
    //Exist only to defeat instantiation
    private TablesList(){};
    //APP can use this to get the singleton reference
    public static TablesList getInstance(){
		if(instance == null)
			instance = new TablesList();
		return instance;
	}
    
    /**
     * @param date the date-session that guests are arriving, pax the number of people having meal, 
     * @param Desire_status eg "vacated", Target_status the status to be changed after the table is booked
     * @return int the table ID
     */
    //get the desired table with the best fit for pax, if there's no table suitable, return -1
	public int check_get(int date, int pax, String Desire_status, String Target_status){
		//if the date is not yet in the hash list, initialize one
		if(tables_with_date.get(new Integer(date)) == null)
			this.initialize(date);
		return tables_with_date.get(new Integer(date)).getTable(pax, Desire_status, Target_status);
	}

	/**
     * @param Target_status the status to be changed to
     */
	public void changeStatus(int date, int ID, String Target_status){
		tables_with_date.get(new Integer(date)).ChangeStatus(ID, Target_status);
	}

	/**
     * @param today the current date-session 
     * @return void, delete all the out dated data
     */
	public void remove_old(int today){
		for(Integer date : tables_with_date.keySet()){
			if(date < today)
				tables_with_date.remove(date);
		}
	}
	private void initialize(int date){
		tables_with_date.put(new Integer(date), new Tables());
	}
}
