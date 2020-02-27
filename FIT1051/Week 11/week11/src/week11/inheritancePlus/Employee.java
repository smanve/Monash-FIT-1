package week11.inheritancePlus;

//abstract because we never intend to instantiate objects from it
//abstract because we want it to contain a abstract method earnings which will be implemented differently for each subclass
public abstract class Employee {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;

	// three-argument constructor
	public Employee(String first, String last, String ssn) {
		firstName = first;
		lastName = last;
		socialSecurityNumber = ssn;
	}

	// first name accessor and mutator
	public void setFirstName(String first) {
		firstName = first; // should validate
	}
	
	public String getFirstName() {
		return firstName;
	}

	// last name accessor and mutator
	public void setLastName(String last) {
		lastName = last; // should validate
	}

	public String getLastName() {
		return lastName;
	}

	// social security number accessor and mutator
	public void setSocialSecurityNumber(String ssn) {
		socialSecurityNumber = ssn; // should validate
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	// return String representation of Employee object
	// @overide is not required but if used the compiler will check it's really overriding
	// i.e. you got the signature correct and are not accidentally overloading or adding a new method altogether - very useful
	@Override
	public String toString() {
		return String.format("%s %s\nsocial security number: %s",
				getFirstName(), getLastName(), getSocialSecurityNumber());
	}

	
	
	// abstract method must be overridden by any concrete subclass
	public abstract double earnings(); // no implementation here, must be implemented in any subclass
}

