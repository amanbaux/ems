package in.ems.model;

public class Product {

	private String customerId;
	private String productCompanyName;
	private String productMfDate;
	private String productExpDate;
	private String productPrice;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProductCompanyName() {
		return productCompanyName;
	}

	public void setProductCompanyName(String productCompanyName) {
		this.productCompanyName = productCompanyName;
	}

	public String getProductMfDate() {
		return productMfDate;
	}

	public void setProductMfDate(String productMfDate) {
		this.productMfDate = productMfDate;
	}

	public String getProductExpDate() {
		return productExpDate;
	}

	public void setProductExpDate(String productExpDate) {
		this.productExpDate = productExpDate;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [customerId=" + customerId + ", productCompanyName=" + productCompanyName + ", productMfDate="
				+ productMfDate + ", productExpDate=" + productExpDate + ", productPrice=" + productPrice + "]";
	}

}
