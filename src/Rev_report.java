
public class Rev_report {
private Menu_Item[] mi_sold;
private int date;
private Promo_Set[] set_sold;
private double revenue;

public Menu_Item[] getGrades(){
	return mi_sold;
}
public void setGrades(Menu_Item[] mi_sold){
	this.mi_sold = mi_sold;
}
public int getDate(){
	return date;
}
public void setDate(){
	this.date = date;
}
public Promo_Set[] getSetSold(){
	return set_sold;
}
public void setSetSold(Promo_Set[] set_sold){
	this.set_sold = set_sold;
}
public double getRevenue(){
	return revenue;
}
public void setRevenue(double revenue){
this.revenue = revenue;
}
public void add_report(Menu_Item[] i){
	
}

public void add_report(Promo_Set[] s){
	
}

public void print_report(){
}

}
