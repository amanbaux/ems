package in.ems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ems.model.MemberCheckInCheckOut;
import in.ems.model.MemberDetails;
import in.ems.model.MemberReport;
import in.ems.model.MembershipInformation;
import in.ems.model.PlacementInformation;
import in.ems.model.StudentDetails;
import in.ems.model.UserDetails;
import in.ems.model.UserRoleInfomation;
import in.ems.model.VisitorDetails;
import in.ems.model.VisitorReoprt;
import in.ems.repository.UserRepository;
import in.ems.request.MemberRequestReport;
import in.ems.request.VisitorReportRequest;
import in.ems.utils.GmsCustomException;
import in.ems.utils.SisCustomException;
import in.ems.utils.VmsCustomException;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository userRepo;

	public Boolean saveUserDetails(UserDetails details) throws VmsCustomException {
		/**
		 * Validate user id
		 */
		Boolean statusUserExist = userRepo.getUserCountByUserId(details.getUserId());
		if (statusUserExist) {
			throw new VmsCustomException("400", "User id already exist");
		}

		/**
		 * Validate user phone
		 */
		Boolean statusPhoneExist = userRepo.getUserCountByPhone(details.getUserPhone());
		if (statusPhoneExist) {
			throw new VmsCustomException("400", "User phone number already exist");
		}
		/**
		 * Validate user address
		 */
		Boolean statusAddressExist = userRepo.getUserCountByAddress(details.getUserAddress());
		if (statusAddressExist) {
			throw new VmsCustomException("400", "User address already exist");
		}

		/**
		 * Save user details in t_user
		 */
		int autogenaratedIdOfUser = userRepo.saveNewUser(details);
		System.out.println("autogenaratedIdOfUser---------------" + autogenaratedIdOfUser);

		/**
		 * Save user address 
		 */

		for (int i = 0; i < details.getUserAddress().size(); i++) {
			details.getUserAddress().get(i).setUserId(autogenaratedIdOfUser);
			userRepo.saveNewAddress(details.getUserAddress().get(i));
		}

		/**
		 * Save user phone
		 */

		for (int i = 0; i < details.getUserPhone().size(); i++) {
			details.getUserPhone().get(i).setUserId(autogenaratedIdOfUser);
			userRepo.saveNewPhone(details.getUserPhone().get(i));
		}

		/**
		 * Save user role
		 */
		for (int i = 0; i < details.getUserRole().size(); i++) {
			details.getUserRole().get(i).setUserId(autogenaratedIdOfUser);
			userRepo.saveNewRole(details.getUserRole().get(i));
		}

		return Boolean.TRUE;

	}

	@Override
	public List<UserRoleInfomation> userRoleSearch() {
		return userRepo.userRoleSearch();
	}
/**
 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */
	@Override
	public Boolean saveStudentDetails(StudentDetails studentDetails) throws SisCustomException {

		Boolean studentIdExist = userRepo.CountByStudentId(studentDetails.getStudentId());
		if (studentIdExist) {
			throw new SisCustomException("400", "Student id already exist");
		}

		Boolean studentAddressExist = userRepo.CountByStudentAddress(studentDetails.getStudentAddress());
		if (studentAddressExist) {
			throw new SisCustomException("400", "student address already exist");
		}

		int studentInformation = userRepo.saveStudentDetails(studentDetails);
		System.out.println("studentInformation" + studentInformation);

		for (int i = 0; i < studentDetails.getStudentAddress().size(); i++) {
			studentDetails.getStudentAddress().get(i).setStudentId(studentDetails.getStudentId());
			userRepo.saveStudentAddress(studentDetails.getStudentAddress().get(i));
		}

		for (int i = 0; i < studentDetails.getPhoneNumber().size(); i++) {
			studentDetails.getPhoneNumber().get(i).setStudentId(studentDetails.getStudentId());
			userRepo.saveStudentPhoneNumber(studentDetails.getPhoneNumber().get(i));
		}

		for (int i = 0; i < studentDetails.getStudentPlacement().size(); i++) {
			studentDetails.getStudentPlacement().get(i).setStudentId(studentDetails.getStudentId());
			userRepo.savestudentPlacement(studentDetails.getStudentPlacement().get(i));
		}

		for (int i = 0; i < studentDetails.getStudentDepartment().size(); i++) {
			studentDetails.getStudentDepartment().get(i).setStudentId(studentDetails.getStudentId());
			userRepo.savestudentDepartment(studentDetails.getStudentDepartment().get(i));
		}

		for (int i = 0; i < studentDetails.getStudentFee().size(); i++) {
			studentDetails.getStudentFee().get(i).setStudentId(studentDetails.getStudentId());
			userRepo.saveStudentFee(studentDetails.getStudentFee().get(i));
		}
		return Boolean.TRUE;

	}

	@Override
	public StudentDetails studentSearch(String studentid) {
		return userRepo.studentSerach(studentid);
	}

	@Override
	public Boolean studentCheckOut(StudentDetails studentDetails) {
		return userRepo.studentCheckOut(studentDetails);
	}

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	@Override
	public Boolean saveMemberDetails(MemberDetails memberDetails) throws GmsCustomException {
		Boolean memberIdExist = userRepo.CountByMemberId(memberDetails.getMemberId());
		if (memberIdExist) {
			throw new GmsCustomException("400", " member id exist");
		}

		Boolean memberAddressExist = userRepo.countByMemberAddress(memberDetails.getMemebrAddress());
		if (memberAddressExist) {
			throw new GmsCustomException("400", "address is alreday exist");
		}

		int autoGengratedId = userRepo.saveMemberDetails(memberDetails);
		System.out.println("autoGengratedId" + autoGengratedId);

		for (int i = 0; i < memberDetails.getMemebrAddress().size(); i++) {
			memberDetails.getMemebrAddress().get(i).setMemberId(memberDetails.getMemberId());
			userRepo.saveMemberAddress(memberDetails.getMemebrAddress().get(i));
		}

		for (int i = 0; i < memberDetails.getMemebrPhoneNumber().size(); i++) {
			memberDetails.getMemebrPhoneNumber().get(i).setMemberId(memberDetails.getMemberId());
			userRepo.saveMemberPhoneNumber(memberDetails.getMemebrPhoneNumber().get(i));
		}

		for (int i = 0; i < memberDetails.getPaymentDetails().size(); i++) {
			memberDetails.getPaymentDetails().get(i).setMemberId(memberDetails.getMemberId());
			userRepo.savePaymentDetials(memberDetails.getPaymentDetails().get(i));
		}

		for(int i=0; i<memberDetails.getMembershipTaken().size(); i++) {
		memberDetails.getMembershipTaken().get(i).setMemberId(memberDetails.getMemberId());
		userRepo.saveMembershipTaken(memberDetails.getMembershipTaken().get(i));
		}
		return Boolean.TRUE;
	}

	@Override
	public MemberDetails memberSearch(String memberId) {
		return userRepo.memberSearch(memberId); 
	}

	@Override
	public List<MemberReport> memberReport(MemberRequestReport memberReport) {
		return userRepo.memberReport(memberReport);
	}

	public Boolean memberCheckOut(MemberDetails memberDetails) {
		return userRepo.memberCheckOut(memberDetails);
	} 
	
	
	
	@Override
	public List<MembershipInformation> memberRoleSearch() {
		return userRepo.memberRoleSearch();
	}

//	@Override
//	public Boolean memberCheckInOut(MemberCheckInCheckOut memberCheckInCheckOut) {
//		return userRepo.saveMemberCheckInOut(memberCheckInCheckOut);
//	}

	

	
	

}

	
