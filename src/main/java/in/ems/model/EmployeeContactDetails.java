package in.ems.model;

public class EmployeeContactDetails {

	private String employeeId;
	private String phoneNumber;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "EmployeeContactDetails [employeeId=" + employeeId + ", phoneNumber=" + phoneNumber + "]";
	}

}
