import java.util.ArrayList;
import java.io.Serializable;

public class PromoSet implements Serializable {

	private ArrayList <Set_Item> sets = new ArrayList <Set_Item>();
	private int MaxID = 0;
	//Exist only to defeat instantiation
	private PromoSet() {}

    private static PromoSet instance = null;

    //APP can use this to get the singleton reference
    public static PromoSet getInstance(){
		if(instance == null)
			instance = new PromoSet();
		return instance;
	}

	public void setInstance() {
		instance = this;
	}

	public Set_Item getSetItem (int itemSetID){
		for(Set_Item set: sets)
		{
			if(set.getSetID() == itemSetID)
				return set;
		}
		return null;
	}

	public void updateSetItem(int setID, String setName, double setPrice) {
		Set_Item set = getSetItem(setID);
		set.setSetName(setName);
		set.setSetPrice(setPrice);
	}


	public void addSet(String setName, double setPrice) {
		Set_Item set = new Set_Item (MaxID, setName, setPrice);
		sets.add(set);
		MaxID++;
	}
	
	public void RemoveSet(int setID){
		Set_Item set = getSetItem(setID);
		sets.remove(set);
	}

	public void addItemToSet(int setID, Menu_Item item){
		Set_Item set = getSetItem(setID);
		set.addItem(item);
	}
	
	public void removeItemFromSet(int setID, Menu_Item item){
		Set_Item set = getSetItem(setID);
		set.removeItem(item);
	}
	
    public void printSets ()
    {
			System.out.println("====== Promotional Sets ======");
			for(Set_Item set : sets)
				set.printSet();

    }



}
