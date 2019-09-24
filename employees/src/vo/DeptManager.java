package vo;

public class DeptManager {
	private Department department;
	private Employees employees;
	private String fromDate;
	private String toDate;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employees getEmployees() {
		return employees;
	}
	public void setEmployees(Employees employees) {
		this.employees = employees;
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
		return "DeptManager [department=" + department + ", employees=" + employees + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}
}
