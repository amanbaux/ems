package in.ems.model;

import java.util.List;

public class UserDetails {

	private String userId;
	private String name;
	private String email;
	private int age;
	private String gender;
	private String dob;
	private String empolyeCode;
	private String idProofType;
	private String idProofNo;
	private String password;
	private List<UserPhone> userPhone;
	private List<UserAddress> userAddress;
	private List<UserRole> userRole;
	

	public List<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}

	public List<UserAddress> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(List<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}

	public List<UserPhone> getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(List<UserPhone> userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmpolyeCode() {
		return empolyeCode;
	}

	public void setEmpolyeCode(String empolyeCode) {
		this.empolyeCode = empolyeCode;
	}

	public String getIdProofType() {
		return idProofType;
	}

	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}

	public String getIdProofNo() {
		return idProofNo;
	}

	public void setIdProofNo(String idProofNo) {
		this.idProofNo = idProofNo;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name + ", email=" + email + ", age=" + age + ", gender="
				+ gender + ", dob=" + dob + ", empolyeCode=" + empolyeCode + ", idProofType=" + idProofType
				+ ", idProofNo=" + idProofNo + ", password=" + password + ", userPhone=" + userPhone + ", userAddress="
				+ userAddress + ", userRole=" + userRole + "]";
	}

	

	
	
}
