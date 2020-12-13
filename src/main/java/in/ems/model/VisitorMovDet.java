package in.ems.model;

public class VisitorMovDet {
	private int vId;
	private String vOrganzation;
	private String meetingPerson;
	private String electronicDevice;
	private String vpurpose;
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

	public String getVpurpose() {
		return vpurpose;
	}

	public void setVpurpose(String vpurpose) {
		this.vpurpose = vpurpose;
	}

	public int getvId() {
		return vId;
	}
	
	public void setvId(int autogenaratedIdOfVisitor) {
		this.vId = autogenaratedIdOfVisitor;
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

	@Override
	public String toString() {
		return "VisitorMovDet [vId=" + vId + ", vOrganzation=" + vOrganzation + ", meetingPerson=" + meetingPerson
				+ ", electronicDevice=" + electronicDevice + ", vpurpose=" + vpurpose + ", checkInTime=" + checkInTime
				+ ", checkOutTime=" + checkOutTime + "]";
	}

}
