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

    //get the desired table with the best fit for pax, if there's no table suitable, return -1
	public int check_get(int date, int pax, String Desire_status, String Target_status){
		//if the date is not yet in the hash list, initialize one
		if(tables_with_date.get(new Integer(date)) == null)
			this.initialize(date);
		return tables_with_date.get(new Integer(date)).getTable(pax, Desire_status, Target_status);
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
