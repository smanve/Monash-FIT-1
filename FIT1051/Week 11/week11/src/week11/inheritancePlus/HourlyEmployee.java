package week11.inheritancePlus;
public class HourlyEmployee extends Employee {
	private double wage; // wage per hour
	private double hours; // hours worked for week

	// five-argument constructor
	public HourlyEmployee(String first, String last, String ssn, double hourlyWage, double hoursWorked) {
		super(first, last, ssn);
		setWage(hourlyWage); // validate hourly wage
		setHours(hoursWorked); // validate hours worked
	}

	// wage accessor and mutator
	public void setWage(double hourlyWage) {
		if (hourlyWage >= 0.0)
			wage = hourlyWage;
		else
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
	}

	public double getWage() {
		return wage;
	}

	// hours accessor and mutator
	public void setHours(double hoursWorked) {
		if ((hoursWorked >= 0.0) && (hoursWorked <= 168.0))
			hours = hoursWorked;
		else
			throw new IllegalArgumentException(
					"Hours worked must be >= 0.0 and <= 168.0");
	}

	public double getHours() {
		return hours;
	}

    // calculate earnings; keep promise to make concrete the abstract method, earnings, in Employee
	@Override
	public double earnings() {
		if (getHours() <= 40) // no overtime
			return getWage() * getHours();
		else
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
	}

	
	// return String representation of HourlyEmployee object
	@Override
	public String toString() {
		return String.format("hourly employee: %s\n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(), "hours worked",
				getHours());
	}
	
}

