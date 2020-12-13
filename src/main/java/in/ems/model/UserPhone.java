package in.ems.model;

public class UserPhone {

	private int userId;
	private String phoneNumber;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int autogenaratedIdOfUser) {
		this.userId = autogenaratedIdOfUser;
	}

	public String getPhoneNumber() {	
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "UserPhone [userId=" + userId + ", phoneNumber=" + phoneNumber + "]";
	}

}
