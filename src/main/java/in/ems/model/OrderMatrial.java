package in.ems.model;

public class OrderMatrial {
	
	private String customerId;
	private String orderNumber;
	private String orderDate;
	private String orderId;
	private String totalOrder;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(String totalOrder) {
		this.totalOrder = totalOrder;
	}
	@Override
	public String toString() {
		return "OrderMatrial [customerId=" + customerId + ", orderNumber=" + orderNumber + ", orderDate=" + orderDate
				+ ", orderId=" + orderId + ", totalOrder=" + totalOrder + "]";
	}
}
