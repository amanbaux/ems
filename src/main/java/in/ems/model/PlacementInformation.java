package in.ems.model;

public class PlacementInformation {

	private String studentId;
	private String placementScore;
	private String companyName;
	private String selectedCompany;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPlacementScore() {
		return placementScore;
	}

	public void setPlacementScore(String placementScore) {
		this.placementScore = placementScore;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSelectedCompany() {
		return selectedCompany;
	}

	public void setSelectedCompany(String selectedCompany) {
		this.selectedCompany = selectedCompany;
	}

	@Override
	public String toString() {
		return "PlacementInformation [studentId=" + studentId + ", placementScore=" + placementScore + ", companyName="
				+ companyName + ", selectedCompany=" + selectedCompany + "]";
	}

}
