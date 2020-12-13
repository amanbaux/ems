package in.ems.model;

import java.util.List;

public class EmployeeDetails {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String idProof;
	private String idProofNumber;
	private String age;
	private String gender;
	private String perviousOrganization;
	private List<EmployeeAddressDetails> employeeAddress;
	private List<EmployeeContactDetails> employeePhoneNumber;
	private List<HrDepartmentDetails> hrDepartmen;
	private List<TransportDetails> transportDetails;
	private List<EmployeeProjectSalary> employeeInfromation;
	private String checkInTime;
	private String checkOutTime;
	
	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getIdProofNumber() {
		return idProofNumber;
	}

	public void setIdProofNumber(String idProofNumber) {
		this.idProofNumber = idProofNumber;
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

	public String getPerviousOrganization() {
		return perviousOrganization;
	}

	public void setPerviousOrganization(String perviousOrganization) {
		this.perviousOrganization = perviousOrganization;
	}

	public List<EmployeeAddressDetails> getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(List<EmployeeAddressDetails> employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public List<EmployeeContactDetails> getEmployeePhoneNumber() {
		return employeePhoneNumber;
	}

	public void setEmployeePhoneNumber(List<EmployeeContactDetails> employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
	}

	public List<HrDepartmentDetails> getHrDepartmen() {
		return hrDepartmen;
	}

	public void setHrDepartmen(List<HrDepartmentDetails> hrDepartmen) {
		this.hrDepartmen = hrDepartmen;
	}

	public List<TransportDetails> getTransportDetails() {
		return transportDetails;
	}

	public void setTransportDetails(List<TransportDetails> transportDetails) {
		this.transportDetails = transportDetails;
	}

	public List<EmployeeProjectSalary> getEmployeeInfromation() {
		return employeeInfromation;
	}

	public void setEmployeeInfromation(List<EmployeeProjectSalary> employeeInfromation) {
		this.employeeInfromation = employeeInfromation;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "EmployeeDetails [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", idProof=" + idProof + ", idProofNumber=" + idProofNumber + ", age=" + age
				+ ", gender=" + gender + ", perviousOrganization=" + perviousOrganization + ", employeeAddress="
				+ (employeeAddress != null ? employeeAddress.subList(0, Math.min(employeeAddress.size(), maxLen))
						: null)
				+ ", employeePhoneNumber="
				+ (employeePhoneNumber != null
						? employeePhoneNumber.subList(0, Math.min(employeePhoneNumber.size(), maxLen))
						: null)
				+ ", hrDepartmen="
				+ (hrDepartmen != null ? hrDepartmen.subList(0, Math.min(hrDepartmen.size(), maxLen)) : null)
				+ ", transportDetails="
				+ (transportDetails != null ? transportDetails.subList(0, Math.min(transportDetails.size(), maxLen))
						: null)
				+ ", employeeInfromation="
				+ (employeeInfromation != null
						? employeeInfromation.subList(0, Math.min(employeeInfromation.size(), maxLen))
						: null)
				+ "]";
	}

}
