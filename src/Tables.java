import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Tables implements Serializable {
	/**
	 * tables, store all the individual table info
	 */
	private List<Table_Item> tables = new ArrayList<Table_Item>();
	/**
	 * Defaut constructor, create a Tables object
	 * @param all_tables all currently tables in restaurant
	 */
	public Tables(List<Integer> all_tables){
		for(int i = 0; i < all_tables.size(); i++){
			tables.add(new Table_Item(i, all_tables.get(i)));
		}
	}

	/**
	 * synchronized method to return a best fit table ID for a certain session, if no table suitable, return -1
     * @param pax the number of people having meal,
     * @param Desire_status eg "vacated", Target_status the status to be changed after the table is booked
     * @return int the table ID if found, otherwise -1
     */
	//thread safe, atomic method to get the desire table and change its status. If no such table found, return -1
	public synchronized int getTable(int pax, String Desire_status, String Target_status){
		int minDiff = Integer.MAX_VALUE;
		int bestFit = -1;
		int diff;
		for(int i = 0; i < tables.size(); i++){
			if(tables.get(i).getStatus().equals(Desire_status)){
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
	/**
	 * public method for other class to change certain table status
	 * @param ID table ID
	 * @param Status the table status
	 */
	public void ChangeStatus(int ID, String Status){
		tables.get(ID).changeStatus(Status);
	}
}
