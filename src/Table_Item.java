import java.lang.String;
import java.io.Serializable;

public class Table_Item implements Serializable{
	/**
	 * ID - table ID
	 * Max_pax - table maximum pax
	 * Status - the status of this table
	 */
	private int ID, Max_pax;
	private String Status; 
	/**
	 * Default constructor, set the status as 'vacated'
	 * @param ID table ID
	 * @param Max_pax table maximum pax
	 */
	public Table_Item(int ID, int Max_pax){
		this.ID = ID;
		this.Max_pax = Max_pax;
		Status = "vacated";
	}
	/**
	 * change the status of this table, setter method
	 * @param Status the status of this table
	 */
	public void changeStatus(String Status){
		this.Status = Status;
	}
	/**
	 * get the status of this table, getter method
	 * @return Status the status of this table
	 */
	public String getStatus(){
		return this.Status;
	}
	/**
	 * get the ID of this table, getter method
	 * @return ID table ID
	 */
	public int getID(){
		return this.ID;
	}
	/**
	 * get the maximum pax of this table, getter method
	 * @return Max_pax table maximum pax
	 */
	public int getMax_pax(){
		return this.Max_pax;
	}
}
