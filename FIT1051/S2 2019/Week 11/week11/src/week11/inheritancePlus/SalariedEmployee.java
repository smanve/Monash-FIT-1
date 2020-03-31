package week11.inheritancePlus;

public class SalariedEmployee extends Employee {
	private double weeklySalary;

	// four-argument constructor
	// note call to super class's Constructor which is efficient since we can't access private inst vars in subclass
	public SalariedEmployee(String first, String last, String ssn, double salary) {
		super(first, last, ssn);  //pass initial values to Employee constructor
		setWeeklySalary(salary);  //validate and initialise salary
	}

	// weeklySalary accessor and mutator
	public void setWeeklySalary(double salary) {
		if (salary >= 0.0)
			weeklySalary = salary;
		else
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

    // calculate earnings; keep promise to make concrete the abstract method, earnings, in Employee
	@Override
	public double earnings() {
		return getWeeklySalary();
	}

	// return String representation of SalariedEmployee object
	// note call to super class's toString which is efficient since we can't access private inst vars in subclass
	@Override
	public String toString() {
		return String.format("salaried employee: %s\n%s: $%,.2f", super.toString(), "weekly salary", getWeeklySalary());
	}
}