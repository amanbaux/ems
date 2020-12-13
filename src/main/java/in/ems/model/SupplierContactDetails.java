package in.ems.model;

public class SupplierContactDetails {
	
	private String supplierId;
	private String phoneNumber;
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "SupplierContactDetails [supplierId=" + supplierId + ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
