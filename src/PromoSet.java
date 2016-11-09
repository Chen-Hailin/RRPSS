import java.util.ArrayList;
import java.io.Serializable;

/**
* Stores the list of promotion sets.
*/
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

    /**
    * Find the promo set from the given id.
    * @param itemSetID The id of set.
    * @return The Set Item from the corresponding id. Null if not found.
    */
	public Set_Item getSetItem (int itemSetID){
		for(Set_Item set: sets)
		{
			if(set.getSetID() == itemSetID)
				return set;
		}
		return null;
	}

    /**
    * Update a set item.
    * @param setID The id which is going to be updated.
    * @param setName The new name of the set.
    * @param setPrice The new price of the set.
    */
	public void updateSetItem(int setID, String setName, double setPrice) {
		Set_Item set = getSetItem(setID);
		set.setSetName(setName);
		set.setSetPrice(setPrice);
	}

    /**
    * Add a new set item.
    * @param setName the new name of the set.
    * @param setPrice the new price of the set.
    */
	public void addSet(String setName, double setPrice) {
		Set_Item set = new Set_Item (MaxID, setName, setPrice);
		sets.add(set);
		MaxID++;
	}
	
    /**
    * Remove a set item.
    * @param setID The id of the set which is going to be removed.
    */
	public void RemoveSet(int setID){
		Set_Item set = getSetItem(setID);
		sets.remove(set);
	}

    /**
    * Add a new menu item to existing set.
    * @param setID The id of the set which is going to be modified.
    * @param item The new item that is going to e added.
    */
	public void addItemToSet(int setID, Menu_Item item){
		Set_Item set = getSetItem(setID);
		set.addItem(item);
	}
	
    /**
    * Removes an item from an existing set.
    * @param setID The id of the set which is going to be modified.
    * @param item The item which is going to be removed.
    */
	public void removeItemFromSet(int setID, Menu_Item item){
		Set_Item set = getSetItem(setID);
		set.removeItem(item);
	}
	
    /**
    * Print all the available sets.
    */
    public void printSets ()
    {
			System.out.println("====== Promotional Sets ======");
			for(Set_Item set : sets)
				set.printSet();

    }
}
