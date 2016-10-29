package assignment2002;
import java.util.ArrayList;
import java.util.LinkedList;

public class Promo_Set {
	
	private static int maxID = 1;
	private int promoID;
	private String promoName;
	private ArrayList<Menu_Item> items = new ArrayList<Menu_Item>();
	private double promoPrice;
	
	public Promo_Set(){
		this.promoID = maxID;
		maxID++;	
	}
	
	public void setPromoName(String promoName) {this.promoName = promoName;}
	
	public void setPromoPrice(double promoPrice) {this.promoPrice = promoPrice;}
	
	public String getPromoName() {return promoName;}
	
	public double getPromoPrice() {return promoPrice;}
	
	public int getPromoID() {return promoID;}
	
	public void addItem(Menu_Item item) {items.add(item);}
	
	public ArrayList<Menu_Item> getItems() {return items;}

	public String toString()
	{
		return (this.promoName + "  " + "$" + this.promoPrice);	
	}
	
	public void printPromo()
	{
		System.out.println("====== Promotional Set ======");
		System.out.println(this.toString());
		System.out.println("Items in the set: ");
		for(Menu_Item item : items)
			System.out.println(item.getItemName());
	}

}
