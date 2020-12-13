package in.ems.model;

public class CustomerContactDetails {
	
	private String customerId;
	private String phoneNumber;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "CustomerContactDetails [customerId=" + customerId + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	

}
