package in.ems.model;

public class SupplierAddress {

	private String supplierId;
	private String supplierAddress;
	
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	@Override
	public String toString() {
		return "SupplierAddress [supplierId=" + supplierId + ", supplierAddress=" + supplierAddress + "]";
	}
	
	
	
	
}
