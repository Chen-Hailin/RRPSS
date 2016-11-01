import java.lang.String;
public class Menu_Item {
	private static int maxID = 1;
	private String itemType, itemDesc, itemName;
	private double itemPrice;
	private int itemID;
	
	
	public Menu_Item (String itemType, String itemDesc, String itemName, double itemPrice){
		this.itemID = maxID;
		this.itemType = itemType;
		this.itemDesc = itemDesc;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		maxID++;
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
	
	
	
	/*public static void main(String[] args) {
		Menu_Item item1 = new Menu_Item("dessert","Sweet and creamy","Tiramisu", 10.95);
		System.out.print(item1.getItemName());
		System.out.printf("  $%.2f",item1.getItemPrice());
		System.out.println();
		System.out.println(item1.getItemType()+"\n"+item1.getItemDesc());
	} */
	 
    public String toString(){
    	return (itemName +"  "+ itemDesc + "  "+"$"+itemPrice);
    }
}


