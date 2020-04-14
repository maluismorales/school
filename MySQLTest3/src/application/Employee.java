package application;

public class Employee {
	
	private String employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	private String officeCode;
	private String reportsTo;
	private String jobTitle;
    
    public Employee (
    		String employeeNumber, 
    		String lastName, 
    		String firstName, 
    		String extension,
    		String email, 
    		String officeCode,
    		String reportsTo,
    		String jobTitle 
    		) {    	
        
  		this.employeeNumber = employeeNumber;
        this.lastName = lastName;
  		this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
  		this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
      }



	public String getEmployeeNumber() {
		return employeeNumber;
	}



	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}



	public String getExtension() {
		return extension;
	}



	public String getEmail() {
		return email;
	}



	public String getOfficeCode() {
		return officeCode;
	}



	public String getReportsTo() {
		return reportsTo;
	}



	public String getJobTitle() {
		return jobTitle;
	}
    
    
    
}

