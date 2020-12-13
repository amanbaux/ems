package in.ems.model;

public class TransportDetails {

	private String employeeId;
	private String takeCabDate;
	private String cabInfo;
	private String destination;
	private String driverName;
	private String employeeDepartment;
	private String fromDestination;

	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getFromDestination() {
		return fromDestination;
	}

	public void setFromDestination(String fromDestination) {
		this.fromDestination = fromDestination;
	}


	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getTakeCabDate() {
		return takeCabDate;
	}

	public void setTakeCabDate(String takeCabDate) {
		this.takeCabDate = takeCabDate;
	}

	public String getCabInfo() {
		return cabInfo;
	}

	public void setCabInfo(String cabInfo) {
		this.cabInfo = cabInfo;
	}

	@Override
	public String toString() {
		return "TransportDetails [employeeId=" + employeeId + ", takeCabDate=" + takeCabDate + ", cabInfo=" + cabInfo
				+ ", destination=" + destination + ", driverName=" + driverName + ", employeeDepartment="
				+ employeeDepartment + ", fromDestination=" + fromDestination + "]";
	}

	
}
