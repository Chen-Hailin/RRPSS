/**
* Stores information about the staff.
*/
public class Staff implements Serializable {
    private int employeeID;
    private String name;
    private String gender;
    private String jobTitle;
    
    /**    
    * Create a new information about staff.
    * @param employeeID A key to identify the staff.
    * @param name The name of the staff.
    * @param gender The gender of the staff.
    * @param jobTitle Current job title of the staff.
    */
    public Staff(int employeeID, String name, String gender, String jobTitle) {
        this.employeeID  = employeeID;
        this.name        = name;
        this.gender      = gender;
        this.jobTitle    = jobTitle;
    }
        
    public int getEmployeeID() {
        return employeeID;
    }
    
    public String getName() {
        return name;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getJobTitle() {
        return jobTitle;
    }
}