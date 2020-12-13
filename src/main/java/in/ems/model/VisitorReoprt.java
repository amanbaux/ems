package in.ems.model;

public class VisitorReoprt {

	private String vName;
	private String vPhone;
	private String vOrganzation;
	private String meetingPerson;
	private String purposeVisit;

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getvPhone() {
		return vPhone;
	}

	public void setvPhone(String vPhone) {
		this.vPhone = vPhone;
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

	public String getPurposeVisit() {
		return purposeVisit;
	}

	public void setPurposeVisit(String purposeVisit) {
		this.purposeVisit = purposeVisit;
	}

	@Override
	public String toString() {
		return "VisitorReoprt [vName=" + vName + ", vPhone=" + vPhone + ", vOrganzation=" + vOrganzation
				+ ", meetingPerson=" + meetingPerson + ", purposeVisit=" + purposeVisit + "]";
	}

}
