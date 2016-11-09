import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

/**
* Stores the list of staff.
*/
public class StaffList implements Serializable {
    private Map<Integer, Staff> staffList = new HashMap<Integer, Staff>();;
        
    private static StaffList instance = null;    
    
    private StaffList(){};
    
    /**
    * App can use this to get singleton reference
    */
    public static StaffList getInstance(){
		if(instance == null)
			instance = new StaffList();
		return instance;
	}

	public void setInstance() {
		instance = this;
	}
    
    /**
    * Add a new staff to the list.
    * @param id The new if of the staff.
    * @param name The new name of the staff.
    * @param gender The new gender of the staff.
    * @param jobTitle The new job title of the staff.
    * @return False if id already exist. True if the staff has been added to the list successfully.
    */
    public boolean addStaff(int id, String name, String gender, String jobTitle) {
        if (staffList.containsKey(new Integer(id))) 
            return false;
        staffList.put(new Integer(id), new Staff(id, name, gender, jobTitle));
        return true;
    }
    
    /**
    * Removes a staff based on the id.
    * @param id The employee ID of the staff.
    * @return The Staff value if successful, or null value if no such id.
    */
    public Staff removeStaff(int id) {
        return staffList.remove(new Integer(id));
    }
    
    /**
    * Get a staff object based on his id.
    * @param id The employee ID of the staff.
    * @return The staff object from the associated ID, null if not found.
    */
    public Staff getStaff(int id) {
        return staffList.get(new Integer(id));
    }
    
    /**
    * Print all available staff information.
    */
    public void printAll() {
        for (Map.Entry<Integer, Staff> entry: staffList.entrySet()) {
            entry.getValue().print();
        }
    }
};