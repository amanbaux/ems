package in.ems.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ems.model.CustomerDetails;
import in.ems.model.EmployeeDetails;
import in.ems.model.EmployeeReport;
import in.ems.model.EmpolyeeSalaryProjectInformation;
import in.ems.model.MemberDetails;
import in.ems.model.MembershipInformation;
import in.ems.model.VisitorDetails;
import in.ems.model.VisitorReoprt;
import in.ems.request.EmployeeRequest;
import in.ems.request.VisitorReportRequest;
import in.ems.response.ApiResponse;
import in.ems.services.VisitorService;
import in.ems.utils.EmployeeCustomeException;
import in.ems.utils.ProductCustomException;
import in.ems.utils.VmsCustomException;

@RestController
@RequestMapping("/ems/visitor")
public class VisitorController {

	@Autowired 
	VisitorService service;

	@PostMapping("/visitor-report-by-date")
	public ResponseEntity<?> visitorReportByDate(@Valid @RequestBody VisitorReportRequest request) {
		System.out.println("------------------" + request.toString());
		List<VisitorReoprt> status = service.visitorReportByDate(request);        
		return new ResponseEntity(status, HttpStatus.OK);
	}

	@PostMapping("/register-new-visitor")
	public ResponseEntity<?> register(@Valid @RequestBody VisitorDetails request) {
		ApiResponse response = new ApiResponse();
		try {
			System.out.println("save visitor" + request.toString());
			Boolean status = service.saveVisitorDetails(request);
			if (status) {
				response.setErrorCode("0"); 
				response.setMessageText("Visitor registered successfully.");
			}
			return new ResponseEntity(response, HttpStatus.OK); 
		} catch (VmsCustomException ex) {
			response.setErrorCode(ex.getErrorCode());
			response.setMessageText(ex.getMessageText()); 
			return new ResponseEntity(response, HttpStatus.OK);  
		} catch (Exception e) {
			response.setErrorCode("400");
			response.setMessageText(e.getLocalizedMessage()); 
			return new ResponseEntity(response, HttpStatus.OK); 
		}

	}

	@PostMapping("/visitor-check-out")
	public ResponseEntity<?> visitorCheckOut(@Valid @RequestBody VisitorDetails request) {
		ApiResponse response = new ApiResponse();
		System.out.println("visitor check out" + request.toString());
		Boolean status = service.visitorCheckout(request);
		if (status) {
			response.setErrorCode("200");
			response.setMessageText("Visitor Checked Out Successfully");
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}

	@GetMapping("/visitor-search")
	public ResponseEntity<?> visitorSearch(@RequestParam("photoIdNumber") String photoIdNumber) {
		System.out.println("Photo id number===============" + photoIdNumber);
		VisitorDetails visitorDetails = service.visitorSearch(photoIdNumber);
		return new ResponseEntity(visitorDetails, HttpStatus.OK);
	}

	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */

	@PostMapping("/empolyee-registration-form")
	public ResponseEntity<?> employeeReistartion(@Valid @RequestBody EmployeeDetails request) {
		ApiResponse response = new ApiResponse();
		try {
			System.out.println("+++++++++++" + request.toString());
			Boolean status = service.saveEmployeeDetails(request);
			if (status) {
				response.setErrorCode("0");
				response.setMessageText("employee register successfully");
			}
			return new ResponseEntity(response, HttpStatus.OK);
		} catch (EmployeeCustomeException ex) {
			response.setErrorCode(ex.getErrorCode());
			response.setMessageText(ex.getMessageText());
			return new ResponseEntity(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setErrorCode("400");
			response.setMessageText(e.getLocalizedMessage());
			return new ResponseEntity(response, HttpStatus.OK);
		}

	}

	@GetMapping("/employee-search-by-id")
	public ResponseEntity<?> employeeSearch(@RequestParam("employeeId") String employeeId) {
		System.out.println("employee id+++++++++++++++++++++ " + employeeId);
		EmployeeDetails employeeDetails = service.employeeSearch(employeeId);
		return new ResponseEntity(employeeDetails, HttpStatus.OK);
	}

	@PostMapping("/employee-report")
	public ResponseEntity<?> employeeReport(@Valid @RequestBody EmployeeRequest request) {
		System.out.println("++++++++++++++++++++" + request.toString());
		List<EmployeeReport> employeeReports = service.employeeReports(request);
		return new ResponseEntity(employeeReports, HttpStatus.OK);
	}

	@PostMapping("/employee-leve-job")
	public ResponseEntity<?> employeeLeveJob(@Valid @RequestBody EmployeeDetails request) {
		ApiResponse response = new ApiResponse();
		System.out.println("employee leve jon++++++++++++++++++++" + request.toString());

		Boolean status = service.leveJob(request);
		if (status) {
			response.setErrorCode("0"); 
			response.setMessageText("employee leve job successfully");
		}
		return new ResponseEntity(response, HttpStatus.OK);

	}
	
	@PostMapping("/employee-check-out")
	public ResponseEntity<?> employeeCheckOut(@Valid @RequestBody EmployeeDetails request) {
		ApiResponse response = new ApiResponse();
		System.out.println("member check out+++++++++++++++++" + request.toString());
		Boolean status = service.employeeCheckOut(request);
		if (status) {
			response.setErrorCode("0");
			response.setMessageText("member check out successfully");
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}


	
	@GetMapping("/empolyee-projectId-salaryId")
	public ResponseEntity<?> projectIdSalaryId(){
		System.out.println("projectIdSalaryId+++++++++++++++++++++++++++++++");
		List<EmpolyeeSalaryProjectInformation> empolyeeSalaryProjectInformations = service.employeeInformation();
		return new ResponseEntity(empolyeeSalaryProjectInformations,HttpStatus.OK);
	}
	
/**
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * @param request
 * @return
 */

	
	@PostMapping("/customer-register")
	public ResponseEntity<?> customerRegister(@Valid @RequestBody CustomerDetails request) {
		ApiResponse response = new ApiResponse();
		try {
			System.out.println("++++++++++++++++++++" + request.toString()); 
			Boolean status = service.saveCustomerDetails(request);
			if (status) {
				response.setErrorCode("0");
				response.setMessageText("customer successfully register");
			} 
			return new ResponseEntity(response, HttpStatus.OK);
		}  
		catch(ProductCustomException ex)   
		{ 
			ex.setErrorCode(ex.getErrorCode());          
			ex.setMessageText(ex.getMessageText()); 
			return new ResponseEntity(response, HttpStatus.OK);   
		}       
		catch(Exception e)   
		{
			response.setErrorCode("400");    
			response.setMessageText(e.getLocalizedMessage());      
			return new ResponseEntity(response, HttpStatus.OK);      
		}

	}

}
