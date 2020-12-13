package in.ems.model;

import java.util.List;

public class MemberDetails {

	private String memberId;
	private String memberName;
	private String fatherName;
	private String joinDate;
	private String joinEndDate;
	private String email;
	private String age;
	private String gender;
	private List<MemebrAddressDetails> memebrAddress;
	private List<MemberContactDetails> memebrPhoneNumber;
	private List<PaymentTypeDeatils> paymentDetails;
	private List<MembershipTaken> membershipTaken;
	private String checkOutTime;
	private String checkInTime;
	private String idProof;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getJoinEndDate() {
		return joinEndDate;
	}

	public void setJoinEndDate(String joinEndDate) {
		this.joinEndDate = joinEndDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<MemebrAddressDetails> getMemebrAddress() {
		return memebrAddress;
	}

	public void setMemebrAddress(List<MemebrAddressDetails> memebrAddress) {
		this.memebrAddress = memebrAddress;
	}

	public List<MemberContactDetails> getMemebrPhoneNumber() {
		return memebrPhoneNumber;
	}

	public void setMemebrPhoneNumber(List<MemberContactDetails> memebrPhoneNumber) {
		this.memebrPhoneNumber = memebrPhoneNumber;
	}

	public List<PaymentTypeDeatils> getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(List<PaymentTypeDeatils> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public List<MembershipTaken> getMembershipTaken() {
		return membershipTaken;
	}

	public void setMembershipTaken(List<MembershipTaken> membershipTaken) {
		this.membershipTaken = membershipTaken;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "MemberDetails [memberId=" + memberId + ", memberName=" + memberName + ", fatherName=" + fatherName
				+ ", joinDate=" + joinDate + ", joinEndDate=" + joinEndDate + ", email=" + email + ", age=" + age
				+ ", gender=" + gender + ", memebrAddress="
				+ (memebrAddress != null ? memebrAddress.subList(0, Math.min(memebrAddress.size(), maxLen)) : null)
				+ ", memebrPhoneNumber="
				+ (memebrPhoneNumber != null ? memebrPhoneNumber.subList(0, Math.min(memebrPhoneNumber.size(), maxLen))
						: null)
				+ ", paymentDetails="
				+ (paymentDetails != null ? paymentDetails.subList(0, Math.min(paymentDetails.size(), maxLen)) : null)
				+ ", membershipTaken="
				+ (membershipTaken != null ? membershipTaken.subList(0, Math.min(membershipTaken.size(), maxLen))
						: null)
				+ ", checkOutTime=" + checkOutTime + ", checkInTime=" + checkInTime + ", idProof=" + idProof + "]";
	}

}
