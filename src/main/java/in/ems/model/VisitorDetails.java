package in.ems.model;

import java.util.List;

public class VisitorDetails {

	private String vId;
	private String vName;
	private String vGender;
	private String photoIdType;
	private String photoIdNumber;
	private String age;
	private String vOrganzation;
	private String meetingPerson;
	private String electronicDevice;
	private List<VisitorMovDet> visitorMovDet;
	private List<VisitorPhoneNo> visitorPhoneNo;
	private List<VisitorAddress> visitorAddress;

	public String getvId() {
		return vId;
	}

	public void setvId(String vId) {
		this.vId = vId;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getvGender() {
		return vGender;
	}

	public void setvGender(String vGender) {
		this.vGender = vGender;
	}

	public String getPhotoIdType() {
		return photoIdType;
	}

	public void setPhotoIdType(String photoIdType) {
		this.photoIdType = photoIdType;
	}

	public String getPhotoIdNumber() {
		return photoIdNumber;
	}

	public void setPhotoIdNumber(String photoIdNumber) {
		this.photoIdNumber = photoIdNumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getvOrganzation() {
		return vOrganzation;
	}

	public void setvOrganzation(String vOrganzation) {
		this.vOrganzation = vOrganzation;
	}

	public String getMeetingPerson() {
		return meetingPerson;
	}

	public void setMeetingPerson(String meetingPerson) {
		this.meetingPerson = meetingPerson;
	}

	public String getElectronicDevice() {
		return electronicDevice;
	}

	public void setElectronicDevice(String electronicDevice) {
		this.electronicDevice = electronicDevice;
	}

	public List<VisitorMovDet> getVisitorMovDet() {
		return visitorMovDet;
	}

	public void setVisitorMovDet(List<VisitorMovDet> visitorMovDet) {
		this.visitorMovDet = visitorMovDet;
	}

	public List<VisitorPhoneNo> getVisitorPhoneNo() {
		return visitorPhoneNo;
	}

	public void setVisitorPhoneNo(List<VisitorPhoneNo> visitorPhoneNo) {
		this.visitorPhoneNo = visitorPhoneNo;
	}

	public List<VisitorAddress> getVisitorAddress() {
		return visitorAddress;
	}

	public void setVisitorAddress(List<VisitorAddress> visitorAddress) {
		this.visitorAddress = visitorAddress;
	}

	@Override
	public String toString() {
		return "VisitorDetails [vId=" + vId + ", vName=" + vName + ", vGender=" + vGender + ", photoIdType="
				+ photoIdType + ", photoIdNumber=" + photoIdNumber + ", age=" + age + ", vOrganzation=" + vOrganzation
				+ ", meetingPerson=" + meetingPerson + ", electronicDevice=" + electronicDevice + ", visitorMovDet="
				+ visitorMovDet + ", visitorPhoneNo=" + visitorPhoneNo + ", visitorAddress=" + visitorAddress + "]";
	}

}
