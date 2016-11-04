import java.util.HashMap;
import java.util.Map;
public class TablesList implements Serializable{
	private Map<Integer, Tables> tables_with_date = new HashMap<Integer, Tables>();
	//when pass the 'date' argument, please ensure the format as YYYYMMDDS 
	//Eg: 201603110 means 11th April 2016, AM session
	private static TablesList instance = null;
	//Exist only to defeat instantiation
	private TablesList(){};
	//APP can use this to get the singleton reference
	public static TablesList getInstance(){
		if(instance == null)
			instance = new TablesList();
		return instance;
	}
	//Check whether the table is available for certain date and pax
	public boolean check(int date, int pax){
		//if this date list does not exist, call the initialize method to put the entry
		if(tables_with_date.get(new Integer(date)) == null)
			this.initialize(date);
		return tables_with_date.get(new Integer(date)).check_availability(pax);
	}
	public int getTable(int date, int pax){
		return tables_with_date.get(new Integer(date)).getTable(pax);
	}
	public void changeStatus(int date, int ID, String Status){
		tables_with_date.get(new Integer(date)).ChangeStatus(ID, Status);
	}
	public void remove_old(int today){
		for(Integer date : tables_with_date.keySet()){
			if(date < today)
				tables_with_date.remove(date);
		}
	}
	public void initialize(int date){
		tables_with_date.put(new Integer(date), new Tables());
	}
}
