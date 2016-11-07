import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Tables implements Serializable {
	private List<Table_Item> tables = new ArrayList<Table_Item>();
	public Tables(){
		for(int i = 0; i < 30; i++){
			if(i < 5)
				tables.add(new Table_Item(i, 10));
			else if(i < 10)
				tables.add(new Table_Item(i, 8));
			else if(i < 20)
				tables.add(new Table_Item(i, 4));
			else
				tables.add(new Table_Item(i, 2));
		}
	}
	
	//thread safe, atomic method to get the desire table and change its status. If no such table found, return -1
	public synchronized int getTable(int pax, String Desire_status, String Target_status){
		int minDiff = Integer.MAX_VALUE;
		int bestFit = -1;
		int diff;
		for(int i = 0; i < tables.size(); i++){
			if(tables.get(i).getStatus()==Desire_status){
				diff = tables.get(i).getMax_pax() - pax;
				if(diff >= 0 && diff < minDiff){
					minDiff = diff;
					bestFit = i;
					if(minDiff == 0)
						break;	
				}
			}
		}
		if (bestFit != -1)
			tables.get(bestFit).changeStatus(Target_status);
		return bestFit;
	}
	
	//public method provided to change back the status of certain table
	public void ChangeStatus(int ID, String Status){
		tables.get(ID).changeStatus(Status);
	}
}
