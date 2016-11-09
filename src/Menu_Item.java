import java.lang.String;
import java.io.Serializable;

/**
* Stores the information of a menu item.
*/
public class Menu_Item implements Serializable{
	private String itemType, itemDesc, itemName;
	private double itemPrice;
	private int itemID;

    /**
    * Constructor.
    * Create a new menu item.
    * @param MaxID The new id of the item.
    * @param itemType The type of the item.
    * @param itemDesc The description of the item.
    * @param itemName The name of the item.
    * @param itemPrice The price of the item.
    */
	public Menu_Item (int MaxID, String itemType, String itemDesc, String itemName, double itemPrice){
		this.itemType = itemType;
		this.itemDesc = itemDesc;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		//this.itemID = StaticIDHandler.getInstance().getMaxMenuID();
		//StaticIDHandler.getInstance().setMaxMenuID(this.itemID + 1);
		this.itemID = MaxID;
	}

    /**
    * Set a new name to the item.
    * @param itemName The new name that will be set.
    */ 
	public void setItemName(String itemName){
		this.itemName = itemName;
	}

    /**
    * Set a new item price.
    * @param itemPrice The new price.
    */
	public void setItemPrice(double itemPrice){
		this.itemPrice = itemPrice;
	}

    /**
    * Set a new description to the item.
    * @param itemDesc The new description.
    */
	public void setItemDesc(String itemDesc){
		this.itemDesc = itemDesc;
	}

    /**
    * Set a new type to the item.
    * @param itemType Give a new type to the item.
    */
	public void setItemType(String itemType){
		this.itemType = itemType;
	}

    /**
    * Returns the id of this item.
    * @return The item id.
    */ 
	public int getItemID(){
		return this.itemID;
	}

    /**
    * Returns the type of this item.
    * @return The item type.
    */
	public String getItemType(){
		return this.itemType;
	}

    /**
    * Returns the description of the item.
    * @return The item description.
    */
	public String getItemDesc(){
		return this.itemDesc;
	}

    /**
    * Returns the name of the item.
    * @return The item name.
    */
	public String getItemName(){
		return this.itemName;
	}

    /**
    * Returns the price of the item.
    * @return The item price.
    */
	public double getItemPrice(){
		return this.itemPrice;
	}

    /**
    * Convert the menu item into String.
    * @return The converted item.
    */
    public String toString(){
    	return (itemName +"  "+ itemDesc + "  "+"$"+itemPrice);
    }
}
