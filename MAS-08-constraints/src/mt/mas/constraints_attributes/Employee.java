package mt.mas.constraints_attributes;

/**
 * @author Mariusz
 *
 */
public class Employee {
	private float salary;

	public Employee(float salary) {
		this.salary = salary;   // required direct assignment
	}

	public float getSalary() {
		return salary;
	}

	/**
	 * @param salary the pensja to set
	 * @throws Exception 
	 */
	public void setSalary(float salary) throws Exception {
		// Validate all the constraints
		if(salary < this.salary) {
			throw new Exception(String.format("The salary (%s) cannot be decreased!%d", salary));
		}
		
		if(this.salary * (1d + maxSalaryChangePercentage /100d) < salary) {
			throw new Exception(String.format("The salary (%s => %s) increase cannot be more then %s%%", this.salary, salary, maxSalaryChangePercentage));
		}

		if(salary < minimumSalary) {
			throw new Exception(String.format("The new salary (%s) has to be at least %s", salary, minimumSalary));
		}
		
		this.salary = salary;
	}	
	
	public final static float minimumSalary = 2000;
	public final static float maximumSalary = 5000;
	public final static int maxSalaryChangePercentage = 10;
}
