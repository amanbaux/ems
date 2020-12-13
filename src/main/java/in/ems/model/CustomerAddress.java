package in.ems.model;

public class CustomerAddress {

	private String customerId;
	private String address;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerAddress [customerId=" + customerId + ", address=" + address + "]";
	}

}
