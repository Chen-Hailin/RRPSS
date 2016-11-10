import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

/**
* Stores the list of staff.
*/
public class StaffList implements Serializable {
    private Map<Integer, Staff> staffList = new HashMap<Integer, Staff>();;
    private int maxID = 1;

    private static StaffList instance = null;

    private StaffList(){};

    /**
    * App can use this to get singleton reference
    * @return instance staffList
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
    * @param name The new name of the staff.
    * @param gender The new gender of the staff.
    * @param jobTitle The new job title of the staff.
    */
    public void addStaff(String name, String gender, String jobTitle) {
        staffList.put(new Integer(maxID), new Staff(maxID, name, gender, jobTitle));
        maxID++;
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
            System.out.println ("####################");
        }
    }
};
