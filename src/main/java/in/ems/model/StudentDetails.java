package in.ems.model;

import java.util.List;

public class StudentDetails {

	private String studentId;
	private String studentName;
	private String studentEmail;
	private int studentAge;
	private String studentGender;
	private String studentCode;
	private String idProofType;
	private String idProofNumber;
	private String joinDate;
	private String fatherName;
	private String branch;
	private List<Address> studentAddress;
	private List<ContactNumber> phoneNumber;
	private List<PlacementInformation> studentPlacement;
	private List<Department> studentDepartment; 
	private List<FeeInformation> studentFee;
	private String checkOutTime;
	private String checkInTime;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getIdProofType() {
		return idProofType;
	}

	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}

	public String getIdProofNumber() {
		return idProofNumber;
	}

	public void setIdProofNumber(String idProofNumber) {
		this.idProofNumber = idProofNumber;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public List<Address> getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(List<Address> studentAddress) {
		this.studentAddress = studentAddress;
	}

	public List<ContactNumber> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<ContactNumber> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<PlacementInformation> getStudentPlacement() {
		return studentPlacement;
	}

	public void setStudentPlacement(List<PlacementInformation> studentPlacement) {
		this.studentPlacement = studentPlacement;
	}

	public List<Department> getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(List<Department> studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	public List<FeeInformation> getStudentFee() {
		return studentFee;
	}

	public void setStudentFee(List<FeeInformation> studentFee) {
		this.studentFee = studentFee;
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

	@Override
	public String toString() {
		return "StudentDetails [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail="
				+ studentEmail + ", studentAge=" + studentAge + ", studentGender=" + studentGender + ", studentCode="
				+ studentCode + ", idProofType=" + idProofType + ", idProofNumber=" + idProofNumber + ", joinDate="
				+ joinDate + ", fatherName=" + fatherName + ", branch=" + branch + ", studentAddress=" + studentAddress
				+ ", phoneNumber=" + phoneNumber + ", studentPlacement=" + studentPlacement + ", studentDepartment="
				+ studentDepartment + ", studentFee=" + studentFee + ", checkOutTime=" + checkOutTime + ", checkInTime="
				+ checkInTime + "]";
	}

}
