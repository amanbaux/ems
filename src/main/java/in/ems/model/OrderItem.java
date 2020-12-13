package in.ems.model;

public class OrderItem {

	private String customerId;
	private String itmeQuntity;
	private String totalItem;
	private String totalAmount;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getItmeQuntity() {
		return itmeQuntity;
	}

	public void setItmeQuntity(String itmeQuntity) {
		this.itmeQuntity = itmeQuntity;
	}

	public String getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(String totalItem) {
		this.totalItem = totalItem;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "OrderItem [customerId=" + customerId + ", itmeQuntity=" + itmeQuntity + ", totalItem=" + totalItem
				+ ", totalAmount=" + totalAmount + "]";
	}

}
