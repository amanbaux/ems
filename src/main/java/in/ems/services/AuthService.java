package in.ems.services;

import java.util.List;

import in.ems.model.EmployeeDetails;
import in.ems.model.MemberCheckInCheckOut;
import in.ems.model.MemberDetails;
import in.ems.model.MemberReport;
import in.ems.model.MembershipInformation;
import in.ems.model.StudentDetails;
import in.ems.model.UserDetails;
import in.ems.model.UserRoleInfomation;
import in.ems.model.VisitorReoprt;
import in.ems.request.MemberRequestReport;
import in.ems.request.VisitorReportRequest;
import in.ems.utils.GmsCustomException;
import in.ems.utils.SisCustomException;
import in.ems.utils.VmsCustomException;

public interface AuthService {
	
	public Boolean saveUserDetails(UserDetails details) throws VmsCustomException;
	
	public List<UserRoleInfomation> userRoleSearch();
	
	
	public Boolean saveStudentDetails(StudentDetails studentDetails) throws SisCustomException; 
	
	public StudentDetails studentSearch(String studentid);
	 
	public Boolean studentCheckOut(StudentDetails studentDetails);
	 
	
	
	public Boolean saveMemberDetails(MemberDetails memberDetails) throws GmsCustomException; 
	
	public MemberDetails memberSearch(String memberId);
	
	public List<MemberReport> memberReport (MemberRequestReport memberReport);
	
	public Boolean memberCheckOut(MemberDetails memberDetails);
	
	public List<MembershipInformation> memberRoleSearch();
	
//	public Boolean memberCheckInOut(MemberCheckInCheckOut memberCheckInCheckOut);
	
	

}
