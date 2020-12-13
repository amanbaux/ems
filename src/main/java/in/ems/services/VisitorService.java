package in.ems.services;

import java.util.List;

import in.ems.model.CustomerDetails;
import in.ems.model.EmployeeDetails;
import in.ems.model.EmployeeReport;
import in.ems.model.EmpolyeeSalaryProjectInformation;
import in.ems.model.VisitorDetails;
import in.ems.model.VisitorReoprt;
import in.ems.request.EmployeeRequest;
import in.ems.request.VisitorReportRequest;
import in.ems.utils.EmployeeCustomeException;
import in.ems.utils.ProductCustomException;
import in.ems.utils.VmsCustomException;

public interface VisitorService {
	
	public Boolean saveVisitorDetails(VisitorDetails visitorDetails) throws VmsCustomException;

	public Boolean visitorCheckout(VisitorDetails details);
	
	public VisitorDetails visitorSearch(String photoIdNumber);

	public List<VisitorReoprt> visitorReportByDate(VisitorReportRequest visitorReoprt); 
	
	public Boolean saveEmployeeDetails(EmployeeDetails employeeDetails) throws EmployeeCustomeException; 
	
	public List<EmployeeReport> employeeReports(EmployeeRequest employeeRequest);
	
	public EmployeeDetails employeeSearch(String employeeId);
	
	public Boolean leveJob(EmployeeDetails hrEmployeeDetails);
	
	public Boolean employeeCheckOut(EmployeeDetails employeeDetails);
	
	public List<EmpolyeeSalaryProjectInformation> employeeInformation();
	
	public Boolean saveCustomerDetails(CustomerDetails customerDetails) throws ProductCustomException;

	
	
	
	 
	
	
 
	

}
