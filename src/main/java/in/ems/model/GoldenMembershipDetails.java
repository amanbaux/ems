package in.ems.model;

public class GoldenMembershipDetails {

	private String memberId;
	private String goldenMembership;
	private String amount;
	private String allEqipumentAllow;

	public String getAllEqipumentAllow() {
		return allEqipumentAllow;
	}

	public void setAllEqipumentAllow(String allEqipumentAllow) {
		this.allEqipumentAllow = allEqipumentAllow;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getGoldenMembership() {
		return goldenMembership;
	}

	public void setGoldenMembership(String goldenMembership) {
		this.goldenMembership = goldenMembership;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "GoldenMembershipDetails [memberId=" + memberId + ", goldenMembership=" + goldenMembership + ", amount="
				+ amount + ", allEqipumentAllow=" + allEqipumentAllow + "]";
	}

	

}
