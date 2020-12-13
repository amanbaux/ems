package in.ems.model;

public class FeeInformation {
	private String studentId;
	private String branch;
	private String studentCode;
	private String collegeFee;
	private String libaryFee;
	private String busFee;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getCollegeFee() {
		return collegeFee;
	}

	public void setCollegeFee(String collegeFee) {
		this.collegeFee = collegeFee;
	}

	public String getLibaryFee() {
		return libaryFee;
	}

	public void setLibaryFee(String libaryFee) {
		this.libaryFee = libaryFee;
	}

	public String getBusFee() {
		return busFee;
	}

	public void setBusFee(String busFee) {
		this.busFee = busFee;
	}

	@Override
	public String toString() {
		return "FeeInformation [studentId=" + studentId + ", branch=" + branch + ", studentCode=" + studentCode
				+ ", collegeFee=" + collegeFee + ", libaryFee=" + libaryFee + ", busFee=" + busFee + "]";
	}

}
