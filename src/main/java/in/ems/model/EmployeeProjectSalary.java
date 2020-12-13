package in.ems.model;

public class EmployeeProjectSalary {// id, employee_id, project_id, salary_id

	private String employeeId;
	private String projectId;
	private String salaryId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(String salaryId) {
		this.salaryId = salaryId;
	}

	@Override
	public String toString() {
		return "EmployeeProjectSalary [employeeId=" + employeeId + ", projectId=" + projectId + ", salaryId=" + salaryId
				+ "]";
	}

}
