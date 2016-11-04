import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rev_rep_list  {
	
	private ArrayList<Order> orders = new ArrayList<Order>(); 
	
	public Rev_rep_list (ArrayList<Order> orders){
		this.orders = orders;
	}
	
	public void list(){
	for (Order o : orders){
		
		System.out.print(o.getDate());
		System.out.print(o.getmenuID());
		System.out.print(o.getpromoID());
		System.out.print(o.totalprice());
		
		
		
	}
	
}
}
