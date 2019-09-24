package vo;

public class Ttitles {
	private Employees employees;
	private String titles;
	private String fromDate;
	private String toDate;
	
	public Employees getEmployees() {
		return employees;
	}
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	public String getTitles() {
		return titles;
	}
	public void setTitles(String titles) {
		this.titles = titles;
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
		return "Ttitles [employees=" + employees + ", titles=" + titles + ", fromDate=" + fromDate + ", toDate="
				+ toDate + "]";
	}
}
