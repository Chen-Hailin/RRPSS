import java.util.ArrayList;
import java.io.Serializable;

/**
* Stores the list of menu items.
*/
public class Menu implements Serializable {
	private ArrayList <Menu_Item> items = new ArrayList<Menu_Item> ();
	private int MaxID = 0;
	//Exist only to defeat instantiation
    private Menu () {}

    private static Menu instance = null;
    
    /**
    * APP can use this to get the singleton reference
    */
    public static Menu getInstance(){
		if(instance == null)
			instance = new Menu();
		return instance;
	}

	public void setInstance() {
		instance = this;
	}

    /**
    * Find the menu item object from the given id.
    * @param itemID The id of the menu.
    * @return The menu item of the corresponding id. Null if not found.
    */ 
	public Menu_Item getMenuItem (int itemID){
		for(Menu_Item item: items)
		{
			if(item.getItemID() == itemID)
				return item;
		}
		return null;
	}

    /**
    * Update the menu.
    * @param itemID The id which is going to be updated.
    * @param itemType The new type of the item.
    * @param itemDesc The new description of the item.
    * @param itemName The new name of the item.
    * @param itemPrice The new price of the item.
    */ 
	public void updateMenuItem(int itemID, String itemType, String itemDesc, String itemName, double itemPrice) {
		Menu_Item item = getMenuItem(itemID);
		item.setItemName(itemName);
		item.setItemType(itemType);
		item.setItemPrice(itemPrice);
		item.setItemDesc(itemDesc);
	}

    /**
    * Add a new item to the menu.
    * @param itemType The type of the item.
    * @param itemDesc The description of the item.
    * @param itemName The name of the item.
    * @param itemPrice The price of the item.
    */ 
	public void addItem(String itemType, String itemDesc, String itemName, double itemPrice) {
		Menu_Item item = new Menu_Item (MaxID, itemType, itemDesc, itemName, itemPrice);
		items.add(item);
		MaxID++;
	}

    /**
    * Remove an item from the menu.
    * @param itemID The id of the corresponding item to be removed.
    */
	public void MenuItemRemove(int itemID){
		Menu_Item item = getMenuItem(itemID);
		items.remove(item);
	}

    /**
    * Prints all available item from this menu.
    */
	public void printMenu()
	{
		System.out.println();
		System.out.println("====== Main ======");
		for (int i = 0; i < items.size(); i++)
		{
			if((items.get(i).getItemType()).compareTo("Main") == 0)
				System.out.println((items.get(i).getItemID())+". "+items.get(i).toString());
		}

		System.out.println();
		System.out.println("====== Side ======");
		for (int i = 0; i < items.size(); i++)
		{
			if((items.get(i).getItemType()).compareTo("Side") == 0)
				System.out.println((items.get(i).getItemID())+". "+items.get(i).toString());
		}

		System.out.println();
		System.out.println("====== Dessert ======");
		for (int i =0; i < items.size(); i++)
		{
			if((items.get(i).getItemType()).compareTo("Dessert") == 0)
				System.out.println((items.get(i).getItemID())+". "+items.get(i).toString());
		}

		System.out.println();
		System.out.println("====== Drink ======");
		for (int i = 0; i < items.size(); i++)
		{
			if((items.get(i).getItemType()).compareTo("Drink") == 0)
				System.out.println((items.get(i).getItemID())+". "+items.get(i).toString());
		}

	}


}
