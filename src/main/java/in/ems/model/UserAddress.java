package in.ems.model;

public class UserAddress {
	private int userId;
	private String address;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int autogenaratedIdOfUser) {
		this.userId = autogenaratedIdOfUser;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserAddress [userId=" + userId + ", address=" + address + "]";
	}

}
