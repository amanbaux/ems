package in.ems.model;

public class PrimaeMembershipDetails {

	private String memberId;
	private String primeMembership;
	private String amount;
	private String lessCommanEquipmentAllow;
	
	
	public String getLessCommanEquipmentAllow() {
		return lessCommanEquipmentAllow;
	}

	public void setLessCommanEquipmentAllow(String lessCommanEquipmentAllow) {
		this.lessCommanEquipmentAllow = lessCommanEquipmentAllow;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPrimeMembership() {
		return primeMembership;
	}

	public void setPrimeMembership(String primeMembership) {
		this.primeMembership = primeMembership;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PrimaeMembershipDetails [memberId=" + memberId + ", primeMembership=" + primeMembership + ", amount="
				+ amount + "]";
	}

	

}
