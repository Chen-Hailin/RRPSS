package assignment2002;

import java.lang.String;
public class Menu_Item {
	private String itemType, itemDescription, itemName;
	private double itemPrice;
	
	public Menu_Item (String itemType, String itemDescription, String itemName, double itemPrice){
		this.itemType = itemType;
		this.itemDescription = itemDescription;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public String getItemType(){
		return this.itemType;
	}
	
	public String getItemDescription(){
		return this.itemDescription;
	}
	
	public String getItemName(){
		return this.itemName;
	}

	public double getItemPrice(){
		return this.itemPrice;
	}
	
	public static void main(String[] args) {
		Menu_Item item1 = new Menu_Item("dessert","Sweet and creamy","Tiramisu", 10.95);
		System.out.print(item1.getItemName());
		System.out.printf("  $%.2f",item1.getItemPrice());
		System.out.println();
		System.out.println(item1.getItemType()+"\n"+item1.getItemDescription());
	}

}


