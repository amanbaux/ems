package in.ems.model;

public class ProjectInformation {
	
	private String employeeId;
	private String employeeWorkingProject;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeWorkingProject() {
		return employeeWorkingProject;
	}
	public void setEmployeeWorkingProject(String employeeWorkingProject) {
		this.employeeWorkingProject = employeeWorkingProject;
	}
	@Override
	public String toString() {
		return "ProjectInformation [employeeId=" + employeeId + ", employeeWorkingProject=" + employeeWorkingProject
				+ "]";
	}
	
	
	

}
