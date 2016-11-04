import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Rev_rep_list  {
	
private ArrayList<Order> items;
	
	
	public Rev_rep_list() {
		
		 items = new ArrayList<Order>();
	}
	private Date date;
	private int Menu_ID;
	private double TotalPrice;
	public Order getItemId(){
		for(Order item: items)
		{
				return item.getItemID();
				
		}
		
	}
	public Order getDate(){
		for(Order item: items)
		{
				return item.getDate();
		}
	}
	public Order getTotalPrice(){
		for(Order item: items)
		{
				return item.getTotalPrice();
		}
	}
	public void list(Date date,int MenuId, double totalPrice){
		
		Rev_rep_list rev = new Rev_rep_list();
		
		System.out.print(rev.getDate());
		System.out.print(rev.getItemId());
		System.out.print(rev.getTotalPrice());
		
		
		
	}
	
}

