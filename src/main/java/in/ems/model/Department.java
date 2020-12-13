package in.ems.model;

public class Department {

	private String studentId;
	private String hodName;
	private String deparementName;
	private String deparementCode;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getHodName() {
		return hodName;
	}

	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	public String getDeparementName() {
		return deparementName;
	}

	public void setDeparementName(String deparementName) {
		this.deparementName = deparementName;
	}

	public String getDeparementCode() {
		return deparementCode;
	}

	public void setDeparementCode(String deparementCode) {
		this.deparementCode = deparementCode;
	}

	@Override
	public String toString() {
		return "Deparement [studentId=" + studentId + ", hodName=" + hodName + ", deparementName=" + deparementName
				+ ", deparementCode=" + deparementCode + "]";
	}

}
