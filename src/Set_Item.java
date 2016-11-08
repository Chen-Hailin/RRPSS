import java.util.ArrayList;
import java.io.Serializable;

public class Set_Item implements Serializable {
	    private static int maxSetID = 1;
	    private int setID;
	    private String setName;
		private ArrayList <Menu_Item> items = new ArrayList<Menu_Item> ();
		private double setPrice;

		public Set_Item (ArrayList<Menu_Item> items) {
			this.items = items;
		}

		public Set_Item(int setID, String setName, double setPrice){
			this.setName = setName;
			this.setPrice = setPrice;
			this.setID = maxSetID;
			maxSetID++;
		}

		public void setSetName(String setName) {this.setName = setName;}

		public void setSetPrice(double setPrice) {this.setPrice = setPrice;}

		public String getSetName() {return setName;}

		public double getSetPrice() {return setPrice;}

		public int getSetID() {return setID;}

		public void addItem(Menu_Item item) {items.add(item);}

		public void removeItem(Menu_Item item) {items.remove(item);}

		public ArrayList <Menu_Item> getItems() {return items;}

		public String toString()
		{
			return (this.setID + " " + this.setName + "  " + "$" + this.setPrice);
		}

		public void printSet()
		{
			System.out.println(this.toString());
			System.out.println("Items in the set: ");
			for(Menu_Item item : items)
				System.out.println(item.getItemName());
		}
}
