package in.ems.model;

public class EmployeeSalary {
	
	private String employeeId;
	private String salaryId;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getSalaryId() {
		return salaryId;
	}
	public void setSalaryId(String salaryId) {
		this.salaryId = salaryId;
	}
	@Override
	public String toString() {
		return "EmployeeSalary [employeeId=" + employeeId + ", salaryId=" + salaryId + "]";
	}
	
	
	
	

}
