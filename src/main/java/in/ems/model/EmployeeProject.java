package in.ems.model;

public class EmployeeProject {
	
	private String employeeId;
	private String projectId;
	
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
	@Override
	public String toString() {
		return "EmployeeProject [employeeId=" + employeeId + ", projectId=" + projectId + "]";
	}
	
	

}
