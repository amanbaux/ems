package in.ems.model;

public class PaymentTypeDeatils {

	private String memberId;
	private String paymentDate;
	private String paymentType;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "PaymentTypeDeatils [memberId=" + memberId + ", paymentDate=" + paymentDate + ", paymentType="
				+ paymentType + "]";
	}

}
