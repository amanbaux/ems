package in.ems.repository;

import java.util.List;

import in.ems.model.ContactNumber;
import in.ems.model.CustomerAddress;
import in.ems.model.CustomerContactDetails;
import in.ems.model.CustomerDetails;
import in.ems.model.EmployeeAddressDetails;
import in.ems.model.EmployeeContactDetails;
import in.ems.model.EmployeeDetails;
import in.ems.model.EmployeeProject;
import in.ems.model.EmployeeProjectSalary;
import in.ems.model.EmployeeReport;
import in.ems.model.EmployeeSalary;
import in.ems.model.EmpolyeeSalaryProjectInformation;
import in.ems.model.HrDepartmentDetails;
import in.ems.model.OrderItem;
import in.ems.model.OrderMatrial;
import in.ems.model.Product;
import in.ems.model.SupplierAddress;
import in.ems.model.SupplierContactDetails;
import in.ems.model.SupplierDetails;
import in.ems.model.TransportDetails;
import in.ems.model.VisitorAddress;
import in.ems.model.VisitorDetails;
import in.ems.model.VisitorMovDet;
import in.ems.model.VisitorPhoneNo;
import in.ems.model.VisitorReoprt;
import in.ems.request.EmployeeRequest;
import in.ems.request.VisitorReportRequest;

public interface VisitorRepository {

	public int saveNewVisitor(VisitorDetails visitorDetails);

	public Boolean saveVisitorAddress(VisitorAddress visitorAddress);

	public Boolean saveNewVisitorPhone(VisitorPhoneNo visitorPhoneNo);

	public Boolean saveNewVisitorMovDet(VisitorMovDet visitorMovDet);

	public Boolean visitorCheckOutTime(VisitorDetails visitorDetails);

	public VisitorDetails visitorSearch(String photoIdNumber);

	public Boolean getVisitorCountByVId(String vId);

	public Boolean getVisitorCountByPhoneNo(List<VisitorPhoneNo> list);

	public Boolean getVisitorCountByAddress(List<VisitorAddress> list);

	public List<VisitorReoprt> visitorReportByDate(VisitorReportRequest visitorReportRequest);
	
	
	public Boolean countByEmployeeId(String employeeId);
	
	public int saveEmployeeDeatils(EmployeeDetails employeeDetails);
	
	public Boolean saveEmployeeAddress(EmployeeAddressDetails employeeAddress);
	
	public Boolean saveEmployeeContact(EmployeeContactDetails contactDetails);
	
	public Boolean saveHrDepartement(HrDepartmentDetails hrDepartmentDetails);
	
	public Boolean saveTransportDetails(TransportDetails transportDetails);
	
	public Boolean saveEmployeeProjectSalary(EmployeeProjectSalary employeeProjectSalary);
	
	public List<EmployeeReport> saveEployeeReport(EmployeeRequest employeeRequest);
	
	public EmployeeDetails saveEmployeeInfo(String employeeId);
	
	public Boolean saveEployeeLeveJob(EmployeeDetails hrEmployeeDetails); 
	
	public Boolean svaeEmployeeCheckOut(EmployeeDetails employeeDetails);
	
	public List<EmpolyeeSalaryProjectInformation> employeeInformation();
	
	
	
	
	public Boolean countByCustomerId(String customerId);
	
	public Boolean countBySupplierrId(String supplierId);
	 

	public int saveCustomerDetails(CustomerDetails customerDetails); 
	 
	public Boolean saveCustomerAddress(CustomerAddress customerAddress);
	
	public Boolean saveContactNumber(CustomerContactDetails customerContactDetails);
	
	public Boolean saveOrderItem(OrderItem orderItem);

	public Boolean saveOrderMatrial(OrderMatrial orderMatrial);
	
	public Boolean saveProduct(Product product);
	
	public Boolean saveSupplierDetails(SupplierDetails supplierDetails);
	
	public Boolean saveSupplierAddress(SupplierAddress supplierAddress);
	
	public Boolean saveSuppplierContact(SupplierContactDetails supllierContactDetails);
	
	

	
}
