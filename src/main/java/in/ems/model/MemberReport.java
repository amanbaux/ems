package in.ems.model;

public class MemberReport {

	
	private String memberName;
	private String fatherName;
	private String joinDate;
	private String EndJoinDate; 
	private String email;
	private String idProof;
	private String gender;
	
	
	public String getEndJoinDate() {
		return EndJoinDate;
	}

	public void setEndJoinDate(String endJoinDate) {
		EndJoinDate = endJoinDate;
	}



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender; 
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}



	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberReport [memberName=" + memberName + ", fatherName=" + fatherName + ", joinDate=" + joinDate
				+ ", EndJoinDate=" + EndJoinDate + ", email=" + email + ", idProof=" + idProof + ", gender=" + gender
				+ "]";
	}

	

	
}
