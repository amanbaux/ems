package in.ems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ems.model.CustomerDetails;
import in.ems.model.EmployeeDetails;
import in.ems.model.EmployeeReport;
import in.ems.model.EmpolyeeSalaryProjectInformation;
import in.ems.model.VisitorDetails;
import in.ems.model.VisitorReoprt;
import in.ems.repository.VisitorRepository;
import in.ems.request.EmployeeRequest;
import in.ems.request.VisitorReportRequest;
import in.ems.utils.EmployeeCustomeException;
import in.ems.utils.ProductCustomException;
import in.ems.utils.VmsCustomException;

@Service
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	VisitorRepository visitorRepository;

	@Override
	public Boolean visitorCheckout(VisitorDetails details) {
		return visitorRepository.visitorCheckOutTime(details);
	}

	@Override
	public VisitorDetails visitorSearch(String photoIdNumber) {
		return visitorRepository.visitorSearch(photoIdNumber);  
	}

	@Override
	public List<VisitorReoprt> visitorReportByDate(VisitorReportRequest visitorReoprt) {
		return visitorRepository.visitorReportByDate(visitorReoprt); 
	}

	@Override
	public Boolean saveVisitorDetails(VisitorDetails visitorDetails) throws VmsCustomException {
		/**
		 * Validate for v id
		 */
		Boolean statusVIdExist = visitorRepository.getVisitorCountByVId(visitorDetails.getvId());
		if (statusVIdExist) {
			throw new VmsCustomException("400", "V id already exist");
		}

		/**
		 * Validate for Phone number
		 */
		Boolean statusPhoneNoExist = visitorRepository.getVisitorCountByPhoneNo(visitorDetails.getVisitorPhoneNo());
		if (statusPhoneNoExist) {
			throw new VmsCustomException("400", "Visitor phone no already exist");
		}

		/**
		 * Validate for Address
		 */
		Boolean statusAddressExist = visitorRepository.getVisitorCountByAddress(visitorDetails.getVisitorAddress());
		if (statusAddressExist) {
			throw new VmsCustomException("400", "Visitor address already exist");
		}

		int autogenaratedIdOfVisitor = visitorRepository.saveNewVisitor(visitorDetails);
		System.out.println("autogenaratedIdOfVisitor---------------" + autogenaratedIdOfVisitor);

		/**
		 * Save Phone detail
		 */
		for (int i = 0; i < visitorDetails.getVisitorPhoneNo().size(); i++) {
			visitorDetails.getVisitorPhoneNo().get(i).setvId(autogenaratedIdOfVisitor);
			visitorRepository.saveNewVisitorPhone(visitorDetails.getVisitorPhoneNo().get(i));
		}

		/**
		 * Save Address
		 */
		for (int i = 0; i < visitorDetails.getVisitorAddress().size(); i++) {
			visitorDetails.getVisitorAddress().get(i).setvId(autogenaratedIdOfVisitor);
			visitorRepository.saveVisitorAddress(visitorDetails.getVisitorAddress().get(i));
		}
		/**
		 * Save movement details
		 */
		for (int i = 0; i < visitorDetails.getVisitorMovDet().size(); i++) {
			visitorDetails.getVisitorMovDet().get(i).setvId(autogenaratedIdOfVisitor);
			visitorRepository.saveNewVisitorMovDet(visitorDetails.getVisitorMovDet().get(i));
		}

		return Boolean.TRUE;

	}

	/**
	 * ____________________________________________________________________________________________________________________
	 */

	public Boolean saveEmployeeDetails(EmployeeDetails employeeDetails) throws EmployeeCustomeException {

		Boolean statusEmployeeIdExist = visitorRepository.countByEmployeeId(employeeDetails.getEmployeeId());
		if (statusEmployeeIdExist) {
			throw new EmployeeCustomeException("400", "Employee Id alreday  Exist");
		}

		int employeeInfromation = visitorRepository.saveEmployeeDeatils(employeeDetails);
		System.out.println("employeeInfromation" + employeeInfromation); 

		for (int i = 0; i < employeeDetails.getEmployeeAddress().size(); i++) {
			employeeDetails.getEmployeeAddress().get(i).setEmployeeId(employeeDetails.getEmployeeId());
			visitorRepository.saveEmployeeAddress(employeeDetails.getEmployeeAddress().get(i));
		}
 
		for (int i = 0; i < employeeDetails.getEmployeePhoneNumber().size(); i++) {
			employeeDetails.getEmployeePhoneNumber().get(i).setEmployeeId(employeeDetails.getEmployeeId());
			visitorRepository.saveEmployeeContact(employeeDetails.getEmployeePhoneNumber().get(i));
		}

		for (int i = 0; i < employeeDetails.getHrDepartmen().size(); i++) {
			employeeDetails.getHrDepartmen().get(i).setEmployeeId(employeeDetails.getEmployeeId());
			visitorRepository.saveHrDepartement(employeeDetails.getHrDepartmen().get(i));
		}

		
		for (int i = 0; i < employeeDetails.getTransportDetails().size(); i++) {
			employeeDetails.getTransportDetails().get(i).setEmployeeId(employeeDetails.getEmployeeId());
			visitorRepository.saveTransportDetails(employeeDetails.getTransportDetails().get(i));
		}

		for(int i=0 ; i<employeeDetails.getEmployeeInfromation().size();i++) {
			employeeDetails.getEmployeeInfromation().get(i).setEmployeeId(employeeDetails.getEmployeeId());
			visitorRepository.saveEmployeeProjectSalary(employeeDetails.getEmployeeInfromation().get(i));
		}
		 
		return Boolean.TRUE;
	}

	@Override
	public List<EmployeeReport> employeeReports(EmployeeRequest employeeRequest) {
		return visitorRepository.saveEployeeReport(employeeRequest);
	}

	@Override
	public EmployeeDetails employeeSearch(String employeeId) {
		return visitorRepository.saveEmployeeInfo(employeeId);
	}

	@Override
	public Boolean leveJob(EmployeeDetails hrEmployeeDetails) {
		return visitorRepository.saveEployeeLeveJob(hrEmployeeDetails);
	}
	
	
	@Override
	public Boolean employeeCheckOut(EmployeeDetails employeeDetails) {
		return visitorRepository.svaeEmployeeCheckOut(employeeDetails);
	}
	
	@Override
	public List<EmpolyeeSalaryProjectInformation> employeeInformation() {
		return visitorRepository.employeeInformation();
	}



	
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=
	

	@Override
	public Boolean saveCustomerDetails(CustomerDetails customerDetails) throws ProductCustomException {
		
		
		Boolean statusCustomerIdExist = visitorRepository.countByCustomerId(customerDetails.getCustomerId());
		if(statusCustomerIdExist) {
			throw new ProductCustomException("400","customer Id alreday exist");
		}
		
		int customerInformation= visitorRepository.saveCustomerDetails(customerDetails);
		System.out.println("customerInformation" + customerInformation);	 
		
		 
		
		for(int i=0; i <customerDetails.getAddress().size();i++) {
			customerDetails.getAddress().get(i).setCustomerId(customerDetails.getCustomerId());
			visitorRepository.saveCustomerAddress(customerDetails.getAddress().get(i));
		}
		
		
		for(int i=0; i<customerDetails.getCustomerContact().size();i++) {
			customerDetails.getCustomerContact().get(i).setCustomerId(customerDetails.getCustomerId());
			visitorRepository.saveContactNumber(customerDetails.getCustomerContact().get(i));
			
		}
		
		for(int i=0; i<customerDetails.getOrderItem().size();i++) {
			customerDetails.getOrderItem().get(i).setCustomerId(customerDetails.getCustomerId());
			visitorRepository.saveOrderItem(customerDetails.getOrderItem().get(i));
		}
		
		for(int i=0;i<customerDetails.getOrderMatrail().size();i++) {
			customerDetails.getOrderMatrail().get(i).setCustomerId(customerDetails.getCustomerId());
			visitorRepository.saveOrderMatrial(customerDetails.getOrderMatrail().get(i));
		}
		
		
		for(int i=0; i<customerDetails.getProduct().size();i++) {
			customerDetails.getProduct().get(i).setCustomerId(customerDetails.getCustomerId());
			visitorRepository.saveProduct(customerDetails.getProduct().get(i));
		}
		
		
		Boolean statusSupplierIdExist = visitorRepository.countBySupplierrId(customerDetails.getCustomerId());
		if(statusSupplierIdExist) {
			throw new ProductCustomException("400","customer Id alreday exist");
		}
		
		
		for(int i=0 ; i< customerDetails.getSupplierDetails().size() ;i++) {
			customerDetails.getSupplierDetails().get(i).setSupplierId(customerDetails.getCustomerId());
			visitorRepository.saveSupplierDetails(customerDetails.getSupplierDetails().get(i));
		}
		
		
		for(int i=0; i<customerDetails.getSupplierAddress().size() ;i++) {
			customerDetails.getSupplierAddress().get(i).setSupplierId(customerDetails.getCustomerId());
			visitorRepository.saveSupplierAddress(customerDetails.getSupplierAddress().get(i));
		}
		
		
		for(int i=0; i<customerDetails.getSupplierContact().size();i++) {
			customerDetails.getSupplierContact().get(i).setSupplierId(customerDetails.getCustomerId());
			visitorRepository.saveSuppplierContact(customerDetails.getSupplierContact().get(i));  
		}
		return Boolean.TRUE; 
		 
	
	}

	
	
}
