package in.ems.model;

public class MembershipTaken {
	
	private String memberId;
	private String membershipId;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMembershipId() {
		return membershipId;
	}
	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}
	@Override
	public String toString() {
		return "MembershipTaken [memberId=" + memberId + ", membershipId=" + membershipId + "]";
	}
	
	

}
