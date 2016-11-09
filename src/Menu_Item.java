import java.lang.String;
import java.io.Serializable;

public class Menu_Item implements Serializable{
	private String itemType, itemDesc, itemName;
	private double itemPrice;
	private int itemID;

//passing in int itemID is not needed
	public Menu_Item (int MaxID, String itemType, String itemDesc, String itemName, double itemPrice){
		this.itemType = itemType;
		this.itemDesc = itemDesc;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		//this.itemID = StaticIDHandler.getInstance().getMaxMenuID();
		//StaticIDHandler.getInstance().setMaxMenuID(this.itemID + 1);
		this.itemID = MaxID;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public void setItemPrice(double itemPrice){
		this.itemPrice = itemPrice;
	}

	public void setItemDesc(String itemDesc){
		this.itemDesc = itemDesc;
	}

	public void setItemType(String itemType){
		this.itemType = itemType;
	}

	public int getItemID(){
		return this.itemID;
	}

	public String getItemType(){
		return this.itemType;
	}

	public String getItemDesc(){
		return this.itemDesc;
	}

	public String getItemName(){
		return this.itemName;
	}

	public double getItemPrice(){
		return this.itemPrice;
	}

    public String toString(){
    	return (itemName +"  "+ itemDesc + "  "+"$"+itemPrice);
    }
}
