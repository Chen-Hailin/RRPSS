import java.util.HashMap;
import java.util.Map;
public class TablesList {
	private Map<Integer, Tables> tables_with_date = new HashMap<Integer, Tables>();
	//when pass the 'date' argument, please ensure the format as YYYYMMDDS 
	//Eg: 201603110 means 11th April 2016, AM session
	public boolean check(int date, int pax){
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
