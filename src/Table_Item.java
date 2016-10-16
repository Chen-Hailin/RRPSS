import java.lang.String;
public class Table_Item {
	private int ID, Max_pax;
	private String Status; 
	public Table_Item(int ID, int Max_pax){
		this.ID = ID;
		this.Max_pax = Max_pax;
		Status = "vacated";
	}
	public void changeStatus(String Status){
		this.Status = Status;
	}
	public String getStatus(){
		return this.Status;
	}
	public int getID(){
		return this.ID;
	}
	public int getMax_pax(){
		return this.Max_pax;
	}
	public static void main(String[] args){
		Table_Item t1 = new Table_Item(0, 10);
		System.out.println(t1.getID()+":"+t1.getMax_pax()+":"+t1.getStatus());
		
	}
}
