import java.util.ArrayList;
import java.util.List;
public class Tables implements Serializable{
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
	public boolean check_availability(int pax){
		for(int i = 0; i < tables.size(); i++){
			if(tables.get(i).getMax_pax() >= pax)
				return true;
		}
		return false;
	}
	public int getTable(int pax){
		int minDiff = Integer.MAX_VALUE;
		int bestFit = 0;
		int diff;
		for(int i = 0; i < tables.size(); i++){
			diff = tables.get(i).getMax_pax() - pax;
			if(diff >= 0 && diff < minDiff){
				minDiff = diff;
				bestFit = i;
				if(minDiff == 0)
					break;	
			}
		}
		return bestFit;
	}
	public void ChangeStatus(int ID, String Status){
		tables.get(ID).changeStatus(Status);
	}
}
