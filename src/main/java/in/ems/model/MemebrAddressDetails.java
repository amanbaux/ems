package in.ems.model;

public class MemebrAddressDetails {

	private String memberId;
	private String address;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MemebrAddressDetails [memberId=" + memberId + ", address=" + address + "]";
	}

}
