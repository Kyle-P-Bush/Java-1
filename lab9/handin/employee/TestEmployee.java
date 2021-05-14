public class TestEmployee{
	public static void main(String[] args){
		Employee[] employees = new Employee[3];
		employees[0] = new SalaryEmployee("Meg Manager", 50_000);
		employees[1] = new CommissionEmployee("Sal Salesman", .15, 3400);  
		employees[2] = new HourlyEmployee("Timmy Temp", 10.50, 25);

		for (Employee worker : employees){
			System.out.println(worker);
			System.out.printf( "Paycheck: $%.02f\n",worker.getPayment() );
		}
	}
}