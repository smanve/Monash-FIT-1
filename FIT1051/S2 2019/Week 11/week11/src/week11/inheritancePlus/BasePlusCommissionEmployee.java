package week11.inheritancePlus;//

public class BasePlusCommissionEmployee extends CommissionEmployee { //note extends CommissionEmployee which extends Employee
	private double baseSalary; // base salary per week

	// six-argument constructor
	public BasePlusCommissionEmployee(String first, String last, String ssn, double sales, double rate, double baseSalary) {
		super(first, last, ssn, sales, rate);
		setBaseSalary(baseSalary); // validate and store base salary
	}

	// baseSalary accessor and mutator
	public void setBaseSalary(double salary) {
		if (salary >= 0.0)
			baseSalary = salary;
		else
			throw new IllegalArgumentException("Base salary must be >= 0.0");
	}

	public double getBaseSalary() {
		return baseSalary;
	}

    // calculate earnings; there is no inherited promise to make concrete the abstract method, earnings, in Employee
    // this is a simple syntactically optional but functionally necessary override
    // note call to super class's earnings which is efficient since we can't access private inst vars in subclass
	// note call to super class's earnings which is efficient since we can't access private inst vars in subclass
	@Override
	public double earnings() {
		return getBaseSalary() + super.earnings();
	}

	
	// return String representation of BasePlusCommissionEmployee object
	@Override
	public String toString() {
		return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
	}
}

