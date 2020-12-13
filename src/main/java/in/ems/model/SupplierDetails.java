package in.ems.model;

public class SupplierDetails {
	
	
	private String customerId;
	private String supplierId;
	private String supplierName;
	private String countryName;
	private String cityName;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "SupplierDetails [customerId=" + customerId + ", supplierId=" + supplierId + ", supplierName="
				+ supplierName + ", countryName=" + countryName + ", cityName=" + cityName + "]";
	}
	
	
	
	

}
