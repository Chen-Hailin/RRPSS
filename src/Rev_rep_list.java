import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rev_rep_list  {
	
	private ArrayList<Order> orders = new ArrayList<Order>(); 
	
	public Rev_rep_list (ArrayList<Order> orders){
		this.orders = orders;
	}
	
	public void list(Menu_Item menuItem,Promo_Set promotionSet){
	for (Order o : orders){
		
		System.out.print(o.getDate());
		System.out.print(o.addOrder(menuItem));
		System.out.print(o.addOrder(promotionSet));
		System.out.print(o.getTotalPrice());
		
		
		
	}
	
}
}
