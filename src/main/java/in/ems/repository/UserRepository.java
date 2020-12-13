package in.ems.repository;

import java.util.List;

import in.ems.model.Address;
import in.ems.model.ContactNumber;
import in.ems.model.Department;
import in.ems.model.FeeInformation;
import in.ems.model.MemberCheckInCheckOut;
import in.ems.model.MemberContactDetails;
import in.ems.model.MemberDetails;
import in.ems.model.MemberReport;
import in.ems.model.MembershipInformation;
import in.ems.model.MembershipTaken;
import in.ems.model.MemebrAddressDetails;
import in.ems.model.PaymentTypeDeatils;
import in.ems.model.PlacementInformation;
import in.ems.model.StudentDetails;
import in.ems.model.User;
import in.ems.model.UserAddress;
import in.ems.model.UserDetails;
import in.ems.model.UserPhone;
import in.ems.model.UserRole;
import in.ems.model.UserRoleInfomation;
import in.ems.request.MemberRequestReport;

public interface UserRepository {
	User findByName(String name);

	Boolean existsByName(String name);

	User save(User user);

	/** 
	 * @param userDetails
	 * @return dint as AI PK
	 */
	public int saveNewUser(UserDetails userDetails);

	public Boolean saveNewAddress(UserAddress userAddress);

	public Boolean saveNewRole(UserRole userRole);

	public Boolean saveNewPhone(UserPhone userPhone);

	public Boolean getUserCountByUserId(String userId);

	public Boolean getUserCountByPhone(List<UserPhone> list);

	public Boolean getUserCountByAddress(List<UserAddress> list);
	
	public List<UserRoleInfomation> userRoleSearch();
	
	
	
	public Boolean CountByStudentId(String studentId);

	public int saveStudentDetails(StudentDetails studentDetails); 
	
	public Boolean saveStudentAddress(Address address);
	
	public Boolean saveStudentPhoneNumber(ContactNumber contactNumber);
	
	public Boolean savestudentPlacement(PlacementInformation placementInformation);
	
    public Boolean savestudentDepartment(Department department);
    
    public Boolean saveStudentFee(FeeInformation feeInformation);
    
    public StudentDetails studentSerach(String studentid);

	 public Boolean CountByStudentAddress(List<Address> list);
	 
	 public Boolean studentCheckOut(StudentDetails studentDetails);
	 
	 
	 
	 public Boolean CountByMemberId(String studentId);
	 
	 public int saveMemberDetails(MemberDetails memberDetails);
	 
	 public Boolean saveMemberAddress(MemebrAddressDetails memebrAddressDetails);
	 
	 public Boolean saveMemberPhoneNumber(MemberContactDetails memberContactDetails);
	 
	 public Boolean savePaymentDetials(PaymentTypeDeatils paymentDetails );
	 
	public Boolean saveMembershipTaken(MembershipTaken membershipTaken);

	 public MemberDetails memberSearch(String memberId); 
	 
	 public Boolean countByMemberAddress(List<MemebrAddressDetails> list);
	 
	 public List<MemberReport> memberReport (MemberRequestReport memberReport);
	 
	 public Boolean memberCheckOut(MemberDetails memberDetails);
	 
	 public List<MembershipInformation> memberRoleSearch(); 
	 
//	 public Boolean saveMemberCheckInOut(MemberCheckInCheckOut memberCheckInCheckOut);
	
}