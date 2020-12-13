package in.ems.model;

public class Address {
	private String studentId;
	private String studentAddress;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "Address [studentId=" + studentId + ", studentAddress=" + studentAddress + "]";
	}

}
