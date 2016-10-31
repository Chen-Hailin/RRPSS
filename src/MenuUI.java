package assignment2002;


import java.util.ArrayList;
import java.util.Scanner;

public class MenuUI {

	MenuControl MenuC = new MenuControl(); 
	int option;
	
	public void displayOptions() {
	Scanner sc = new Scanner(System.in);
	System.out.println("1. Create menu item");
	System.out.println("2. Update menu item");
	System.out.println("3. Remove menu item");
	option = sc.nextInt();
		
	if (option == 1)
		requestItemDetails();
	else if (option ==2)
		requestItemID();
	else if (option ==3)
		MenuC.MenuRemove();
	else
		System.out.println("Invalid.");
	}
	

	private void requestItemID() {
		int itemID;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter itemID to modify: ");
		itemID = sc.nextInt();
		MenuC.DisplayItem(itemID);
		retrieveUpdatedDetails(itemID);
	}

	public void requestItemDetails() {
		Scanner sc = new Scanner(System.in);
		String itemName;
		String itemDesc = "";
		String itemType = "";
		double price =0.0;
		System.out.println("Enter item name:");
		itemName = sc.next();
		itemDesc = sc.nextLine();
		System.out.println("Enter item description:");
		itemDesc = sc.nextLine();
		System.out.println("Enter type");
		itemType = sc.next();
		System.out.println("Enter price:");
		price = sc.nextDouble();
		MenuC.createItem(itemName,itemDesc,itemType,price);
		}
		
		
	public MenuControl getMenuC(){
		return this.MenuC;
	}
		
	public void initItemData(){
		MenuC.initItems();
	}

	public ArrayList<Menu_Item> retrieveItemsUI(){
		return MenuC.getMenuItems();
	}

	public static void creationComplete(Menu_Item item) {
		System.out.println("Item :"+ item.getItemID()+" " + item.getItemName() + " has been created.");
	}

	public  void retrieveUpdatedDetails(int itemID) {
		Scanner sc = new Scanner(System.in);
		String itemName;
		String itemDesc = "";
		double price =0.0;
		System.out.println("Enter item name:");
		itemName = sc.next();
		itemDesc = sc.nextLine();
		System.out.println("Enter item description:");
		itemDesc = sc.nextLine();
		System.out.println("Enter price:");
		price = sc.nextDouble();
		MenuC.updateItem(itemID,itemName,itemDesc,price);
	}

	public static void UpdateComplete(Menu_Item item) {
		System.out.println("Item :"+ item.getItemID()+" " + item.getItemName() + " has been updated.");
	}

	public static int getID() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter item ID to remove: ");
		return (sc.nextInt());
	}

	public static void removeComplete(Menu_Item item) {
		System.out.println("Item  has been removed.");
	}
		
	public ArrayList<Menu_Item> getItems() {		
		return MenuC.getMenuItems();
	}
}
