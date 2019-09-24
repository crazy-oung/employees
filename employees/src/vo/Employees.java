package vo;

public class Employees {
	//번호, 성, 이름, 성별, 생일 , 입사일
	private int empNo;
	private String lastName;	
	private String firstName;
	private String birthDate;
	private String hireDate;
	private String gender;
	

	@Override
	public String toString() {
		return "Employees [empNo=" + empNo + ", empLastName=" + lastName + ", empFirstName=" + firstName
				+ ", birthDate=" + birthDate + ", gender=" + gender + "]";
	}
	
	public String getHireDate() {
		return hireDate;
	}
	
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String empLastName) {
		this.lastName = empLastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String empFirstName) {
		this.firstName = empFirstName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
