package in.ems.model;

public class MemberCheckInCheckOut {

	private String memberId;
	private String checkInTime;
	private String checkOutTime;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	@Override
	public String toString() {
		return "MemberCheckInCheckOut [memberId=" + memberId + ", checkInTime=" + checkInTime + ", checkOutTime="
				+ checkOutTime + "]";
	}

}
