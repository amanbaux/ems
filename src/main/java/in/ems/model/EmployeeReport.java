package in.ems.model;

public class EmployeeReport {

	private String firstName;
	private String lastName;
	private String emailId;
	private String gender;
	private String idProof;
	private String checkInTime;
	private String checkOutTime;
	
	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "EmployeeReport [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", gender=" + gender + ", idProof=" + idProof + ", checkInTime=" + checkInTime + ", checkOutTime="
				+ checkOutTime + "]";
	}


}
