package in.ems.model;

public class HrDepartmentDetails {

	private String employeeId;
	private String hireDate;
	private String leveJobDate;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getLeveJobDate() {
		return leveJobDate;
	}

	public void setLeveJobDate(String leveJobDate) {
		this.leveJobDate = leveJobDate;
	}

	@Override
	public String toString() {
		return "HrDepartmentDetails [employeeId=" + employeeId + ", hireDate=" + hireDate + ", leveJobDate="
				+ leveJobDate + "]";
	}

}
