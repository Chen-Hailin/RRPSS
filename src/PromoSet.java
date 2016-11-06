import java.util.ArrayList;

public class PromoSet {

	private ArrayList <Set_Item> sets = new ArrayList <Set_Item>();

	public PromoSet() {}

    //Exist only to defeat instantiation
    private static PromoSet instance = null;

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


	public void addSet(int setID, String setName, double setPrice) {
		Set_Item set = new Set_Item (setID, setName, setPrice);
		sets.add(set);
	}

	public void MenuItemRemove(int setID){
		Set_Item set = getSetItem(setID);
		sets.remove(set);
	}

    public void printSets ()
    {
			System.out.println("====== Promotional Sets ======");
			for(Set_Item set : sets)
				set.printSet();

    }



}
