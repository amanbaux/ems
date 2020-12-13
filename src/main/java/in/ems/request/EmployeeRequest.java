package in.ems.request;

public class EmployeeRequest {
	
	private String employeeId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "EmployeeRequest [employeeId=" + employeeId + "]";
	}
	
	
}
