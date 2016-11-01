import java.util.ArrayList;

public class MenuControl {
	
	private ArrayList<Menu_Item> items;
	
	public MenuControl() {
		
		 items = new ArrayList<Menu_Item>();
	}
	
	public Menu_Item getItem(int itemID){
		for(Menu_Item item: items)
		{
			if(item.getItemID() == itemID)
				return item;
		}
		return null;
	}
		
	public void MenuRemove(){
		int getID;
		getID = MenuUI.getID();
		items.remove(getItem(getID));
		MenuUI.removeComplete(getItem(getID));
	}

	public void createItem(String itemType, String itemDesc, String itemName, double itemPrice) {
		Menu_Item item = new Menu_Item (itemType, itemDesc, itemName, itemPrice);
		items.add(item);
		MenuUI.creationComplete(item);
	}
	
	public ArrayList<Menu_Item> getMenuItems(){
		return items;
	}
	
	public void initItems(){
		items.add(new Menu_Item("Main", "Delicious Hainanese cusine", "Chicken Rice", 4.00));
		items.add(new Menu_Item("Main", "Plate of local delight", "Char Kway Teow", 3.50));
		items.add(new Menu_Item("Drink", "Quenches your thirst", "Sprite", 1.20));
		items.add(new Menu_Item("Dessert", "Rich in taste", "Tiramisu", 4.50));
		items.add(new Menu_Item("Main", "No MSG added", "Ban Mian", 3.50));
		items.add(new Menu_Item("Drink", "Hot tea with milk and sugar", "Teh C", 0.90));
		items.add(new Menu_Item("Main", "Indonesian juicy cripsy chicken", "Ayam Panyet", 5.00));
		items.add(new Menu_Item("Side", "Refreshing appetizer", "Green salad", 3.90));
		items.add(new Menu_Item("Side", "Delicious Japanese octopus ball", "Takoyaki", 2.50));
	}

	public void updateItem(int itemID, String itemName, String itemDesc, double price) {
		Menu_Item item = null;
		item = getItem(itemID);
		item.setItemName(itemName);
		item.setItemDesc(itemDesc);
		item.setItemPrice(price);
		MenuUI.UpdateComplete(item);
	}


	public void DisplayItem(int itemID) {
		for(Menu_Item item: items)
		{
			if(item.getItemID() == itemID)
				System.out.println(item.toString());
		}
	}
	
}
