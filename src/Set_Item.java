import java.util.ArrayList;
import java.io.Serializable;

/**
* Stores the information of a promotion.
*/
public class Set_Item implements Serializable {
	    private int setID;
	    private String setName;
		private ArrayList <Menu_Item> items = new ArrayList<Menu_Item> ();
		private double setPrice;

        /**
        * Constructor.
        * Create a new promotion set from given items.
        * @param items The items contained by the set.
        */
		public Set_Item (ArrayList<Menu_Item> items) {
			this.items = items;
		}

        /**
        * Constructor.
        * Create a new set.
        * @param setID The new ID of the set.
        * @param setName The new name of the set.
        * @param setPrice The price of the set.
        */
		public Set_Item(int setID, String setName, double setPrice){
			this.setName = setName;
			this.setPrice = setPrice;
			//this.setID = StaticIDHandler.getInstance().getMaxSetID();
			//StaticIDHandler.getInstance().setMaxSetID(this.setID + 1);
		}

        /**
        * Gives a new name to the set.
        * @param setName the new name of the set.
        */
		public void setSetName(String setName) {this.setName = setName;}

        /**
        * Gives a new price to the set.
        * @param setPrice The new rice of the set.
        */
		public void setSetPrice(double setPrice) {this.setPrice = setPrice;}

        /**
        * @return The name of the set.
        */
		public String getSetName() {return setName;}

        /**
        * @return The price of the set.
        */
		public double getSetPrice() {return setPrice;}

        /**
        * @return The id of the set.
        */
		public int getSetID() {return setID;}

        /**
        * Add a menu item to the set.
        * @param item The item which is going to be added to this set.
        */
		public void addItem(Menu_Item item) {items.add(item);}

        /**
        * Removes an item from the set.
        * @param item The item that is going to be removed.
        */
		public void removeItem(Menu_Item item) {items.remove(item);}

        /**
        * @return The list of items promoted by this set.
        */
		public ArrayList <Menu_Item> getItems() {return items;}

        /**
        * Convert this set item into string.
        * @return The converted item.
        */
		public String toString()
		{
			return (this.setID + " " + this.setName + "  " + "$" + this.setPrice);
		}

        /**
        * Print the information of this set item.
        */
		public void printSet()
		{
			System.out.println(this.toString());
			System.out.println("Items in the set: ");
			for(Menu_Item item : items)
				System.out.println(item.getItemName());
		}
}
