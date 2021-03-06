import java.io.Serializable;

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
        
    /**
    * @return The id of the employee.
    */
    public int getEmployeeID() {
        return employeeID;
    }
    
    /**
    * @return The name of the employee.
    */
    public String getName() {
        return name;
    }
    
    /**
    * @return The gender of the employee.
    */
    public String getGender() {
        return gender;
    }
    
    /**
    * @return The job title of the employee.
    */    
    public String getJobTitle() {
        return jobTitle;
    }
    
    /**
    * Print the information of a staff.
    */
    public void print() {
        System.out.println("Staff information:");
        System.out.println("Employee ID: " + getEmployeeID());
        System.out.println("Name: " + getName());
        System.out.println("Gender: " + getGender());
        System.out.println("Job Title: " + getJobTitle());
    }
}