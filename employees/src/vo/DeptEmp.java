package vo;

public class DeptEmp {
	private Employees employees;
	private Department department;
	private String fromDate;
	private String toDate;
	
	public Employees getEmployees() {
		return employees;
	}
	public void setEmployees() {
		this.employees = new Employees();
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment() {
		this.department = new Department();
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
		return "DeptEmp [employees=" + employees + ", department=" + department + ", fromDate=" + fromDate + ", toDate="
				+ toDate + "]";
	}
}
