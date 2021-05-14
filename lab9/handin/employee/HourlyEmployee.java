public class HourlyEmployee extends Employee{
	private double hourlyRate;
	private double hoursWorked;

	public HourlyEmployee(String name, double hourlyRate, double hoursWorked){
		super(name); //invoked a constructor of parent class
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	public double getPayment(){
		return this.hoursWorked * this.hourlyRate;
	}

	public String toString(){
		String employeeName = super.toString();
		return String.format("%s, hourly:$%.02f @ %.02f hours", employeeName, this.hourlyRate, this.hoursWorked);
	}
}