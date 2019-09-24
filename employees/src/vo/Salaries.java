package vo;

public class Salaries {
	private Employees employees;
	private int salary;
	private String fromDate;
	private String toDate;
	
	public Employees getEmployees() {
		return employees;
	}
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	@Override
	public String toString() {
		return "Salaries [employees=" + employees + ", salary=" + salary + ", fromDate=" + fromDate + ", toDate="
				+ toDate + "]";
	}
}
