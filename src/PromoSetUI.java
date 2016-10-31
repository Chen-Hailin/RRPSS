package assignment2002;

import java.util.ArrayList;
import java.util.Scanner;

public class PromoSetUI {
	PromoSetControl promoC = new PromoSetControl();
	ArrayList<Menu_Item> items ;

	public PromoSetUI(ArrayList<Menu_Item> items) {
		this.items = items;
	}
	
	public void displayOptions()
	{
		int option;
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Create promo set");
		System.out.println("2.Update promo set");
		System.out.println("3.Remove promo set");
		option = sc.nextInt();
		if(option == 1)
			requestPromoDetails();
		else if(option ==2)
			requestPromoID();
		else if (option ==3)
			{promoC.getListofPromo();
			System.out.println("Enter promo ID to remove:");
			int promoID = sc.nextInt();
			promoC.removePromoItem(promoID);}
		else
			System.out.println("Invalid.");
	}
	
	private void requestPromoID() {
		int promoID;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter promoID to modify: ");
		promoID = sc.nextInt();
		promoC.DisplayPromo(promoID);
		retrieveDetails(promoID);
	}
	
	private void retrieveDetails(int promoID) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		int itemID = 1;
		System.out.println("1.To update name");
		System.out.println("2.To add items");
		System.out.println("3.To remove items");
		System.out.println("4.To update price");
		option = sc.nextInt();
		if(option == 1) {
			String name;
			System.out.println("Enter new name:");
			name = sc.nextLine();
			name = sc.nextLine();
		
			for(Promo_Set promo:promoC.getPromoList()) {
				if(promo.getPromoID()==promoID) {
					promo.setPromoName(name );
					break; }
			}
	    }
		
		else if(option == 2){
		    System.out.println("Enter id to add:");
		    itemID=sc.nextInt();
			while(itemID>0){
				for(Menu_Item item:items){
					if(itemID==item.getItemID())
						{promoC.getPromo(promoID).addItem(item);
						System.out.println("Enter id to add:");
						itemID=sc.nextInt();
						break;}
				}
			}
		}
		
		else if (option == 3) {
			System.out.println("Enter id to remove:");
			itemID=sc.nextInt();
			while(itemID>0) {
				for(Menu_Item item:items){
					if(itemID == item.getItemID()){
						promoC.removePromoItem(promoC.getPromo(promoID),item);
						System.out.println("Enter id to remove:");
						itemID=sc.nextInt();
						break;}
				}
			}	
		}
		
		else if(option == 4){
			System.out.println("Enter new price:");
			double price = sc.nextDouble();
			promoC.getPromo(promoID).setPromoPrice(price);
		}
	}
	
	public void requestPromoDetails() {
		Scanner sc = new Scanner(System.in);
		String promoName;
		int promoID = promoC.createPromo();
		System.out.println("Enter promo name:");
		promoName = sc.nextLine();
		promoC.getPromo(promoID).setPromoName(promoName);
		System.out.println("Enter item ID to add(enter -1 if there is no item");
	
		int itemID = sc.nextInt();
		while (itemID != -1) {
			for(Menu_Item item : items) {
				if(item.getItemID() == itemID)
					{promoC.getPromo(promoID).addItem(item);
						System.out.println("Add this to Promotional Set" + item.toString());
						break; }
		}
			
		System.out.println("Enter item ID to add (otherwise enter -1)");
		itemID = sc.nextInt();
		
		System.out.println("Enter price of promotional set:");
		double promoPrice = sc.nextDouble();
		promoC.getPromo(promoID).setPromoPrice(promoPrice);
		promoC.getPromo(promoID).printPromo();

	}
	
	public void getPromo() {
		promoC.getListofPromo();
	}	
}
