package in.ems.model;

public class ContactNumber {
	private String studentId;
	private String phoneNumber;

	public String getStudentId() {
		return studentId;	
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "ContactNumber [studentId=" + studentId + ", phoneNumber=" + phoneNumber + "]";
	}

}
