package in.ems.model;

public class VisitorPhoneNo {

	private int vId;
	private String phoneNo;

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getphoneNo() {
		return phoneNo;
	}

	public void setphoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "VisitorPhoneNo [vId=" + vId + ", phoneNo=" + phoneNo + "]";
	}

}
