package in.ems.model;

public class MemberContactDetails {

	private String memberId;
	private String phoneNumber;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "MemberContactDetails [memberId=" + memberId + ", phoneNumber=" + phoneNumber + "]";
	}

	

	

}
