import java.util.ArrayList;

public class Menu {
	private ArrayList<Menu_Item> items = new ArrayList<Menu_Item> ();

	public Menu (ArrayList<Menu_Item> items) {
		this.items = items;
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
