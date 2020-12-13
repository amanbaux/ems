package in.ems.model;

public class VisitorAddress {

	private int vId;
	private String vaddress;

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getVaddress() {
		return vaddress;
	}

	public void setVaddress(String vaddress) {
		this.vaddress = vaddress;
	}

	@Override
	public String toString() {
		return "VisitorAddress [vId=" + vId + ", vaddress=" + vaddress + "]";
	}

}
