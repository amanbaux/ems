package in.ems.model;

import java.util.List;

public class CustomerDetails {

	private String customerId;
	private String customerName;
	private String shopName;
	private String shopId;
	private List<CustomerContactDetails> customerContact;
	private List<CustomerAddress> address;
	private List<OrderItem> orderItem;
	private List<OrderMatrial> orderMatrail;
	private List<Product> product;
	private List<SupplierDetails> supplierDetails;
	private List<SupplierAddress> supplierAddress;
	private List<SupplierContactDetails> supplierContact;

	public List<SupplierContactDetails> getSupplierContact() {
		return supplierContact;
	}

	public void setSupplierContact(List<SupplierContactDetails> supplierContact) {
		this.supplierContact = supplierContact;
	}

	public List<SupplierDetails> getSupplierDetails() {
		return supplierDetails;
	}

	public void setSupplierDetails(List<SupplierDetails> supplierDetails) {
		this.supplierDetails = supplierDetails;
	}

	public List<SupplierAddress> getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(List<SupplierAddress> supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public List<CustomerContactDetails> getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(List<CustomerContactDetails> customerContact) {
		this.customerContact = customerContact;
	}

	public List<CustomerAddress> getAddress() {
		return address;
	}

	public void setAddress(List<CustomerAddress> address) {
		this.address = address;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public List<OrderMatrial> getOrderMatrail() {
		return orderMatrail;
	}

	public void setOrderMatrail(List<OrderMatrial> orderMatrail) {
		this.orderMatrail = orderMatrail;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "CustomerDetails [customerId=" + customerId + ", customerName=" + customerName + ", shopName=" + shopName
				+ ", shopId=" + shopId + ", customerContact="
				+ (customerContact != null ? customerContact.subList(0, Math.min(customerContact.size(), maxLen))
						: null)
				+ ", address=" + (address != null ? address.subList(0, Math.min(address.size(), maxLen)) : null)
				+ ", orderItem=" + (orderItem != null ? orderItem.subList(0, Math.min(orderItem.size(), maxLen)) : null)
				+ ", orderMatrail="
				+ (orderMatrail != null ? orderMatrail.subList(0, Math.min(orderMatrail.size(), maxLen)) : null)
				+ ", product=" + (product != null ? product.subList(0, Math.min(product.size(), maxLen)) : null)
				+ ", supplierDetails="
				+ (supplierDetails != null ? supplierDetails.subList(0, Math.min(supplierDetails.size(), maxLen))
						: null)
				+ ", supplierAddress="
				+ (supplierAddress != null ? supplierAddress.subList(0, Math.min(supplierAddress.size(), maxLen))
						: null)
				+ ", supplierContact="
				+ (supplierContact != null ? supplierContact.subList(0, Math.min(supplierContact.size(), maxLen))
						: null)
				+ "]";
	}

}
