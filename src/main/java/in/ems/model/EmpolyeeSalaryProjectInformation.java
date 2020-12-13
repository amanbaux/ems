package in.ems.model;

public class EmpolyeeSalaryProjectInformation {

	private String projectName;
	private String id;
//	private String projectId;
//	private String salaryId;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "EmpolyeeSalaryProjectInformation [projectName=" + projectName + ", id=" + id + "]";
	}

//	public String getProjectId() {
//		return projectId;
//	}
//
//	public void setProjectId(String projectId) {
//		this.projectId = projectId;
//	}
//
//	public String getSalaryId() {
//		return salaryId;
//	}
//
//	public void setSalaryId(String salaryId) {
//		this.salaryId = salaryId;
//	}

	

	
	

	
}
