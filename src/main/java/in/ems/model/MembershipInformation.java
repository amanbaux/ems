package in.ems.model;

public class MembershipInformation {

	private String membershipName;
	private String amount;
	private String equiementAccess;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMembershipName() {
		return membershipName;
	}

	public void setMembershipName(String membershipName) {
		this.membershipName = membershipName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getEquiementAccess() {
		return equiementAccess;
	}

	public void setEquiementAccess(String equiementAccess) {
		this.equiementAccess = equiementAccess;
	}

	@Override
	public String toString() {
		return "MembershipInformation [membershipName=" + membershipName + ", amount=" + amount + ", equiementAccess="
				+ equiementAccess + ", id=" + id + "]";
	}

	

}
