import java.util.ArrayList;
import java.io.Serializable;

public class Menu implements Serializable {
	private ArrayList <Menu_Item> items = new ArrayList<Menu_Item> ();
	
    public Menu () {}
	
    //Exist only to defeat instantiation
    private static Menu instance = null;	
	
    public static Menu getInstance(){
		if(instance == null)
			instance = new Menu();
		return instance;
	}
	
	public Menu_Item getMenuItem (int itemID){
		for(Menu_Item item: items)
		{
			if(item.getItemID() == itemID)
				return item;
		}
		return null;
	}
	
	public void updateMenuItem(int itemID, String itemType, String itemDesc, String itemName, double itemPrice) {
		Menu_Item item = getMenuItem(itemID);
		item.setItemName(itemName);
		item.setItemType(itemType);
		item.setItemPrice(itemPrice);
		item.setItemDesc(itemDesc);
	}
	

	public void addItem(int itemID, String itemType, String itemDesc, String itemName, double itemPrice) {
		Menu_Item item = new Menu_Item (itemID, itemType, itemDesc, itemName, itemPrice);
		items.add(item);
	}
	
	public void MenuItemRemove(int itemID){
		Menu_Item item = getMenuItem(itemID);
		items.remove(item);
	}

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
