package in.ems.model;

public class LocalMembershipDetails {

	private String memberId;
	private String localMembership;
	private String amount;
	private String commanEquipment;

	public String getCommanEquipment() {
		return commanEquipment;
	}

	public void setCommanEquipment(String commanEquipment) {
		this.commanEquipment = commanEquipment;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getLocalMembership() {
		return localMembership;
	}

	public void setLocalMembership(String localMembership) {
		this.localMembership = localMembership;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "LocalMembershipDetails [memberId=" + memberId + ", localMembership=" + localMembership + ", amount="
				+ amount + ", commanEquipment=" + commanEquipment + "]";
	}

	

}
