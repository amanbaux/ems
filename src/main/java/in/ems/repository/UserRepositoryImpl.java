package in.ems.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import in.ems.model.Address;
import in.ems.model.ContactNumber;
import in.ems.model.Department;
import in.ems.model.FeeInformation;
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
import in.ems.model.UserMapper;
import in.ems.model.UserPhone;
import in.ems.model.UserRole;
import in.ems.model.UserRoleInfomation;
import in.ems.request.MemberRequestReport;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	private JdbcTemplate jdbc;

	@Autowired
	NamedParameterJdbcTemplate namedJdbc;

	private String tableName = "t_user";

	@Override
	public User findByName(String name) {
		String sql = "  select usr.user_id,role.role_id,usr.password,usr.id from t_user usr inner join user_role role on usr.id=role.user_id where usr.user_id=? limit 1;";
		User user = (User) jdbc.queryForObject(sql, new Object[] { name }, new UserMapper());
		return user;
	}

	@Override
	public Boolean existsByName(String name) {
		String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE user_id = ?";
		Integer count = jdbc.queryForObject(sql, new Object[] { name }, Integer.class);
		return count != null && count > 0;
	}

	@Override
	public User save(User user) {
		String sql = "INSERT INTO " + tableName + " (user_id, password, role) VALUES (?, ?, ?)";
		jdbc.update(sql, user.getUserId(), user.getPassword(), user.getRole());
		return user;
	}

	@Override 
	public int saveNewUser(UserDetails userDetails) {
		String sql = "INSERT INTO `corp_vms`.`t_user` (`user_id`, `name`, `email`, `age`, `gender`, `empolyee_code`, `id_proof_type`, `id_proof_number`, `created_by`, `updated_by`,`password`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		/**
		 * New way
		 */
		GeneratedKeyHolder matIdHolder = new GeneratedKeyHolder();
		jdbc.update((Connection con) -> {
			PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, userDetails.getUserId());
			preparedStatement.setString(2, userDetails.getName());
			preparedStatement.setString(3, userDetails.getEmail());
			preparedStatement.setInt(4, userDetails.getAge());
			preparedStatement.setString(5, userDetails.getGender());
			preparedStatement.setString(6, userDetails.getEmpolyeCode());
			preparedStatement.setString(7, userDetails.getIdProofType());
			preparedStatement.setString(8, userDetails.getIdProofNo());
			preparedStatement.setString(9, "Aman");
			preparedStatement.setString(10, "Aman"); 
			preparedStatement.setString(11, userDetails.getPassword());

			return preparedStatement;
		}, matIdHolder);
		return matIdHolder.getKey().intValue();
	}

	@Override
	public Boolean saveNewAddress(UserAddress userAddress) {
		String sql = "INSERT INTO `corp_vms`.`user_address` (`user_id`, `address`) VALUES (?, ?);";
		jdbc.update(sql, userAddress.getUserId(), userAddress.getAddress());
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveNewPhone(UserPhone userPhone) {
		String sql = "INSERT INTO `corp_vms`.`user_Phone` (`user_id`, `phone`) VALUES (?, ?);";
		jdbc.update(sql, userPhone.getUserId(), userPhone.getPhoneNumber());
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveNewRole(UserRole userRole) {
		String sql = "INSERT INTO `corp_vms`.`user_Role` (`user_id`, `role_Id`) VALUES (?, ?);";
		jdbc.update(sql, userRole.getUserId(), userRole.getRoleId());
		return Boolean.TRUE;
	}

	@Override
	public Boolean getUserCountByUserId(String userId) {
		String sql = "select count(*) from corp_vms.t_user where user_id='" + userId + "';";
		int count = jdbc.queryForObject(sql, Integer.class);
		if (count > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;

	}

	@Override
	public Boolean getUserCountByPhone(List<UserPhone> list) {

		/**
		 * Collecting phone no in list
		 */
		List<String> phoneNumberList = new ArrayList<>();
		for (UserPhone phone : list) {
			phoneNumberList.add(phone.getPhoneNumber());
		}

		/**
		 * Setting phone no in map
		 */
		Map<String, List<String>> map = new HashMap<>();
		map.put("phoneNoList", phoneNumberList);

		/**
		 * Fetching all matched record by phone list
		 */
		String sql = "select count(*) from corp_vms.user_phone where phone in (:phoneNoList);";
		System.out.println("SQL---------------" + sql);
		int count = namedJdbc.queryForObject(sql, map, Integer.class);
		if (count > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;

	}

	@Override
	public Boolean getUserCountByAddress(List<UserAddress> list) {

		/**
		 * Collecting address no in list
		 */
		List<String> addressList = new ArrayList<>();
		for (UserAddress address : list) {
			addressList.add(address.getAddress());
		}
		/**
		 * setting address in map
		 */
		Map<String, List<String>> map = new HashMap<>();
		map.put("addressList", addressList);
		String sql = "select count(*) from corp_vms.user_address where address in (:addressList);";
		int count = namedJdbc.queryForObject(sql, map, Integer.class);
		if (count > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;

	}

	@Override
	public List<UserRoleInfomation> userRoleSearch() {
		String sql = "select id,role_name,role_desc from role;";

		List<UserRoleInfomation> response = new ArrayList<>();
		response = namedJdbc.query(sql, new ResultSetExtractor<List<UserRoleInfomation>>() {

			@Override 
			public List<UserRoleInfomation> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UserRoleInfomation> role = new ArrayList<>();

				while (rs.next()) {
					UserRoleInfomation newRole = new UserRoleInfomation();
					newRole.setRoleDesc(rs.getString("role_desc"));
					newRole.setRoleId(rs.getInt("id"));
					newRole.setRoleName(rs.getString("role_name"));
					role.add(newRole);
				}
				return role;
			}
		});
		return response;
	}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		

	@Override
	public int saveStudentDetails(StudentDetails studentDetails) {
		String sql = "INSERT INTO `corp_vms`.`student` (" + "`student_id`," + " `student_name`, " + "`student_email`, "
				+ "`student_age`," + " `student_gender`," + " `student_code`, " + "`id_proof_type`,"
				+ " `id_proof_number`, " + "`created_by`," + " `updated_by`," + " `father_name`, " + "`join_date`, "
				+ "`branch`," + "`check_out_time`," + "`check_in_time`) "
				+ "VALUES (?, ?,?,?, ?,?, ?, ?, ?, ?, ?, ?, ?,?,now());";
		GeneratedKeyHolder matIdHolder = new GeneratedKeyHolder();
		jdbc.update((Connection con) -> {
			PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, studentDetails.getStudentId());
			preparedStatement.setString(2, studentDetails.getStudentName());
			preparedStatement.setString(3, studentDetails.getStudentEmail());
			preparedStatement.setInt(4, studentDetails.getStudentAge());
			preparedStatement.setString(5, studentDetails.getStudentGender());
			preparedStatement.setString(6, studentDetails.getStudentCode());
			preparedStatement.setString(7, studentDetails.getIdProofType());
			preparedStatement.setString(8, studentDetails.getIdProofNumber());
			preparedStatement.setString(9, "aman");
			preparedStatement.setString(10, "aman");
			preparedStatement.setString(11, studentDetails.getFatherName());
			preparedStatement.setString(12, studentDetails.getJoinDate());
			preparedStatement.setString(13, studentDetails.getBranch());
			preparedStatement.setString(14, studentDetails.getCheckOutTime());

			return preparedStatement;
		}, matIdHolder);
		return matIdHolder.getKey().intValue();

	}

	@Override
	public Boolean saveStudentAddress(Address address) {
		String sql = "INSERT INTO `corp_vms`.`address` (`student_id`, `address`) VALUES (?, ?);";
		jdbc.update(sql, address.getStudentId(), address.getStudentAddress());
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveStudentPhoneNumber(ContactNumber contactNumber) {
		String sql = "INSERT INTO `corp_vms`.`contact_number` (`student_id`, `phone_number`) VALUES (?, ?);";
		jdbc.update(sql, contactNumber.getStudentId(), contactNumber.getPhoneNumber());
		return Boolean.TRUE;
	}

	@Override
	public Boolean CountByStudentId(String studentId) {
		String sql = "select count(*) from corp_vms.student where student_id='" + studentId + "';";
		int count = jdbc.queryForObject(sql, Integer.class);
		if (count > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean CountByStudentAddress(List<Address> list) {
		List<String> addressList = new ArrayList<>();
		for (Address address : list) {
			addressList.add(address.getStudentAddress());
		}
		Map<String, List<String>> map = new HashMap<>();
		map.put("addressList", addressList);
		String sql = "SELECT count(*) from address where address in (:addressList);";
		int count = namedJdbc.queryForObject(sql, map, Integer.class);
		if (count > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean savestudentPlacement(PlacementInformation placementInformation) {
		String sql = "INSERT INTO `corp_vms`.`placement_information` (`student_id`, `placement_score`, `company_name`, `selected_company`) VALUES (?,?, ?,?);";
		jdbc.update(sql, placementInformation.getStudentId(), placementInformation.getPlacementScore(),
				placementInformation.getCompanyName(), placementInformation.getSelectedCompany());
		return Boolean.TRUE;
	}

	@Override
	public Boolean savestudentDepartment(Department department) {
		String sql = "INSERT INTO `corp_vms`.`deparment` (`student_id`, `hod_name`, `deparment_name`, `deparment_code`) VALUES (?,?,?,?);";
		jdbc.update(sql, department.getStudentId(), department.getHodName(), department.getDeparementName(),
				department.getDeparementCode());
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveStudentFee(FeeInformation feeInformation) {
		String sql = "INSERT INTO `corp_vms`.`fee_information` (`student_id`, `student_code`, `college_fee`, `libary_fee`, `bus_fee`) VALUES (?,?, ?,?,?);";
		jdbc.update(sql, feeInformation.getStudentId(), feeInformation.getStudentCode(), feeInformation.getCollegeFee(),
				feeInformation.getLibaryFee(), feeInformation.getBusFee());
		return Boolean.TRUE;
	}

	@Override
	public StudentDetails studentSerach(String studentid) {
		String sql = "SELECT \r\n" + "    stu.student_name,\r\n" + "    stu.id_proof_type,\r\n"
				+ "    stu.student_email,\r\n" + "    stu.branch,\r\n" + "    stu.id_proof_number\r\n" + "FROM\r\n"
				+ "    student stu\r\n" + "        INNER JOIN\r\n"
				+ "    address addr ON stu.student_id = addr.student_id\r\n" + "        INNER JOIN\r\n"
				+ "    contact_number cont ON stu.student_id = cont.student_id\r\n" + "        INNER JOIN\r\n"
				+ "    deparment dep ON stu.student_id = dep.student_id\r\n" + "        INNER JOIN\r\n"
				+ "    fee_information fee ON stu.student_id = fee.student_id\r\n" + "        INNER JOIN\r\n"
				+ "    placement_information palc ON stu.student_id = palc.student_id\r\n" + "    \r\n"
				+ "    where stu.student_id='" + studentid + "';\r\n" + "";

		StudentDetails response = new StudentDetails();
		response = namedJdbc.query(sql, new ResultSetExtractor<StudentDetails>() {

			@Override
			public StudentDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
				StudentDetails student = new StudentDetails();

				while (rs.next()) {
					student.setStudentName(rs.getString("student_name"));
					student.setIdProofType(rs.getString("id_proof_type"));
					student.setStudentEmail(rs.getString("student_email"));
					student.setBranch(rs.getString("branch"));
					student.setIdProofNumber(rs.getString("id_proof_number"));

				}
				return student;
			}
		});
		return response;
		
	}

	@Override
	public Boolean studentCheckOut(StudentDetails studentDetails) {
		String sql = "update  corp_vms.student set check_out_time=now() where  student_id='"
				+ studentDetails.getStudentId() + "';";
		jdbc.update(sql);

		return Boolean.TRUE;
	}

	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	@Override
	public int saveMemberDetails(MemberDetails memberDetails) {
		String sql = "INSERT INTO `gms`.`member_details` (`member_id`, `member_name`, `father_name`, `join_date`, `end_join_date`, `email`, `age`, `gender`, `created_by`, `updated_by`,`check_in_time`,`check_out_time`,`id_proof`) VALUES (?, ?, ?, now(),?,?,?, ?,?, ?,now(),?,?);";
		GeneratedKeyHolder matIdHolder = new GeneratedKeyHolder();
		jdbc.update((Connection con) -> {
			PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, memberDetails.getMemberId());
			preparedStatement.setString(2, memberDetails.getMemberName());
			preparedStatement.setString(3, memberDetails.getFatherName());
			preparedStatement.setString(4, memberDetails.getJoinEndDate());
			preparedStatement.setString(5, memberDetails.getEmail());
			preparedStatement.setString(6, memberDetails.getAge());
			preparedStatement.setString(7, memberDetails.getGender());
			preparedStatement.setString(8, "aman");
			preparedStatement.setString(9, "aman");
			preparedStatement.setString(10, memberDetails.getCheckOutTime());
			preparedStatement.setString(11, memberDetails.getIdProof());

			return preparedStatement;
		}, matIdHolder);
		return matIdHolder.getKey().intValue();

	}

	@Override
	public Boolean CountByMemberId(String studentId) {
		String sql = "select count(*) from gms.member_details where member_id='" + studentId + "';";
		int count = jdbc.queryForObject(sql, Integer.class);
		if (count > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean saveMemberAddress(MemebrAddressDetails memebrAddressDetails) {
		String sql = "INSERT INTO `gms`.`member_address_details` (`member_id`, `address`) VALUES (?,?);";
		jdbc.update(sql, memebrAddressDetails.getMemberId(), memebrAddressDetails.getAddress());

		return Boolean.TRUE;
	}

	@Override
	public Boolean saveMemberPhoneNumber(MemberContactDetails memberContactDetails) {
		String sql = "INSERT INTO `gms`.`member_contact_number` (`member_id`, `phoneNumber`) VALUES (?,?);";
		jdbc.update(sql, memberContactDetails.getMemberId(), memberContactDetails.getPhoneNumber());
		return Boolean.TRUE;
	}

	@Override
	public Boolean savePaymentDetials(PaymentTypeDeatils paymentDetails) {
		String sql = "INSERT INTO `gms`.`payment_type_deatils` (`member_id`, `payment_date`, `payment_type`) VALUES (?, ?, ?);";
		jdbc.update(sql, paymentDetails.getMemberId(), paymentDetails.getPaymentDate(),
				paymentDetails.getPaymentType());
		return Boolean.TRUE;
	}

	@Override
	public MemberDetails memberSearch(String memberId) {
		String sql = "select   member_id,member_name, father_name, join_date, end_join_date, email, id_proof\r\n"
				+ "from gms.member_details\r\n" + "where member_id='" + memberId + "'";

		MemberDetails response = new MemberDetails();
		response = namedJdbc.query(sql, new ResultSetExtractor<MemberDetails>() {

			@Override
			public MemberDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
				MemberDetails member = new MemberDetails();

				while (rs.next()) {
					member.setMemberId(rs.getString("member_id"));
					member.setMemberName(rs.getString("member_name"));
					member.setFatherName(rs.getString("father_name"));
					member.setJoinDate(rs.getString("join_date"));
					member.setJoinEndDate(rs.getString("end_join_date"));
					member.setIdProof(rs.getString("id_proof"));

				}
				return member;
			}
		});
		return response;
	}

	@Override
	public Boolean countByMemberAddress(List<MemebrAddressDetails> list) {
		List<String> address = new ArrayList<>();
		for (MemebrAddressDetails memberAddress : list) {
			address.add(memberAddress.getAddress());
		}
		Map<String, List<String>> map = new HashMap<>();
		map.put("address", address);
		String sql = "select count(*) from  gms.member_address_details where address in (:address);";
		int count = namedJdbc.queryForObject(sql, map, Integer.class);
		if (count > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;

	}

	@Override
	public List<MemberReport> memberReport(MemberRequestReport memberReport) {
		System.out.println("memberReport+++++++++++++++++"+memberReport.toString()); 
		List<MemberReport> report = new ArrayList<>();
		String sqlForMember = "SELECT  member_name,father_name,join_date,end_join_date,email,id_proof,gender \r\n"
				+ "from gms.member_details\r\n" + "where member_id='" + memberReport.getmemberId() + "'";

		report = namedJdbc.query(sqlForMember, new ResultSetExtractor<List<MemberReport>>() {

			@Override
			public List<MemberReport> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<MemberReport> memberRow = new ArrayList<>();
				while (rs.next()) {
					MemberReport report = new MemberReport();
					report.setMemberName(rs.getString("member_name"));
					report.setFatherName(rs.getString("father_name"));
					report.setJoinDate(rs.getString("join_date"));
					report.setEndJoinDate(rs.getString("end_join_date"));
					report.setEmail(rs.getString("email"));
					report.setIdProof(rs.getString("id_proof"));
					report.setGender(rs.getString("gender"));
					memberRow.add(report);
					
				}
				return memberRow; 
			}

		});
		return report; 
	}

	@Override
	public Boolean memberCheckOut(MemberDetails memberDetails) {
		String sql = " update gms.member_details\r\n" + "	set check_out_time=now()\r\n"
				+ "	where member_id='"+memberDetails.getMemberId()+"';";
		jdbc.update(sql);
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveMembershipTaken(MembershipTaken membershipTaken) {
		System.out.println("membershipTaken-----------------" + membershipTaken.toString());
		String sql = "INSERT INTO `gms`.`membership_taken` (`member_id`, `membership_id`) VALUES (?,?);";
		jdbc.update(sql, membershipTaken.getMemberId(), membershipTaken.getMembershipId());
		return Boolean.TRUE;
	}

	@Override
	public List<MembershipInformation> memberRoleSearch() {
		String sql = "select id, membership_name, amount, equiement_access from gms.membership_details;";
		List<MembershipInformation> response = new ArrayList<>();
		response = namedJdbc.query(sql, new ResultSetExtractor<List<MembershipInformation>>() {

			@Override
			public List<MembershipInformation> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<MembershipInformation> role = new ArrayList<>();

				while (rs.next()) {
					MembershipInformation newRole = new MembershipInformation();
					newRole.setMembershipName(rs.getString("membership_name"));
					newRole.setAmount(rs.getString("amount"));
					newRole.setEquiementAccess(rs.getString("equiement_access"));
					newRole.setId(rs.getInt("id"));
					role.add(newRole);
				}
				return role;
			}
		});
		return response;
	}



}
