public class SalaryEmployee extends Employee{
	private double salary;

	public SalaryEmployee(String name, double salary){
		super(name);
		this.salary = salary;
	}

	public double getPayment(){
		return (this.salary / 12) / 2 ;
	}

	public String toString(){
		String employeeName = super.toString();
		return String.format("%s, salary:$%.02f", employeeName, this.salary);
	}
}