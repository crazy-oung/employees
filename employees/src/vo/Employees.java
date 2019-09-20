package vo;

public class Employees {
	//번호, 성, 이름, 성별, 생일 , 입사일
	private int empNo;
	private String empLastName;	
	private String empFirstName;
	private String birthDate;
	private String hireDate;
	private String gender;
	

	@Override
	public String toString() {
		return "Employees [empNo=" + empNo + ", empLastName=" + empLastName + ", empFirstName=" + empFirstName
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
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
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
