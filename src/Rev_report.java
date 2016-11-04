import java.util.ArrayList;

public class Rev_report {
private Rev_rep_list[] item_sold;
private int month;
private double revenue;

private ArrayList<Rev_rep_list> items;


public Rev_report() {
	
	 items = new ArrayList<Rev_rep_list>();
}

public Rev_rep_list[] getitemsold(){
	return item_sold;
}
public void setitemSold(Rev_rep_list[] item_sold){
	this.item_sold = item_sold;
}
public int getMonth(){
	return month;
}
public void setMonth(int Month){
	this.month = Month;
}

public double getRevenue(){
	return revenue;
}
public void setRevenue(double revenue){
this.revenue = revenue;
}
public void add_item(){
	
}

public void add_set(){
	
}
public double total(){
return revenue;
}
public void print_report(){
	 Rev_report rep1 = new Rev_report();
	System.out.println("====== Sales Revenue report by Month ======");
	
			System.out.printf("Jan:" + rep1.total());
			System.out.printf("Feb:" + rep1.total());
			System.out.printf("Mar:" + rep1.total());
			System.out.printf("Apr:" + rep1.total());
			System.out.printf("May:" + rep1.total());
			System.out.printf("Jun:" + rep1.total());
			System.out.printf("Jul:" + rep1.total());
			System.out.printf("Aug:" + rep1.total());
			System.out.printf("Sept:" + rep1.total());
			System.out.printf("Oct:" + rep1.total());
			System.out.printf("Nov:" + rep1.total());
			System.out.printf("Dec:" + rep1.total());
		
}

}
