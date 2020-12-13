package in.ems.model;

public class EmployeeAddressDetails {

	private String employeeId;
	private String employeeAddress;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	@Override
	public String toString() {
		return "EmployeeAddressDetails [employeeId=" + employeeId + ", employeeAddress=" + employeeAddress + "]";
	}

}
