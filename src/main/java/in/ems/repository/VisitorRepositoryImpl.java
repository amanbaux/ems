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

import in.ems.model.CustomerAddress;
import in.ems.model.CustomerContactDetails;
import in.ems.model.CustomerDetails;
import in.ems.model.EmployeeAddressDetails;
import in.ems.model.EmployeeContactDetails;
import in.ems.model.EmployeeDetails;
import in.ems.model.EmployeeProjectSalary;
import in.ems.model.EmployeeReport;
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
import in.ems.utils.CommonUtils;

@Repository
public class VisitorRepositoryImpl implements VisitorRepository {

	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	NamedParameterJdbcTemplate namedJdbc;

	@Override
	public int saveNewVisitor(VisitorDetails visitorDetails) {
		String sql = "INSERT INTO `corp_vms`.`visitor_info` ( `V_name`, `v_gender`, `photo_id_type`, `photo_id_number`, `created_by`, `updated_by`,`age`) VALUES(?,?,?,?,?,?,?);";
		/**
		 * this way for token provider
		 */
		GeneratedKeyHolder matIdHolder = new GeneratedKeyHolder();
		jdbc.update((Connection con) -> {
			PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, visitorDetails.getvName());
			preparedStatement.setString(2, visitorDetails.getvGender());
			preparedStatement.setString(3, visitorDetails.getPhotoIdType());
			preparedStatement.setString(4, visitorDetails.getPhotoIdNumber());
			preparedStatement.setString(5, ("aman"));
			preparedStatement.setString(6, ("aman"));
			preparedStatement.setString(7, visitorDetails.getAge());
			return preparedStatement;
		}, matIdHolder);
		return matIdHolder.getKey().intValue();
	}

	@Override
	public Boolean saveVisitorAddress(VisitorAddress visitorAddress) {
		String sql = "insert into visitor_address (`v_id`,`v_address`,`created_by`,`updated_by`) values(?,?,?,?);";
		jdbc.update(sql, visitorAddress.getvId(), visitorAddress.getVaddress(), "aman", "aman");
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveNewVisitorPhone(VisitorPhoneNo visitorPhoneNo) {
		String sql = "insert into visitor_phone (`v_id`,`v_phone_no`,`created_by`,`updated_by`) values(?,?,?,?);";
		jdbc.update(sql, visitorPhoneNo.getvId(), visitorPhoneNo.getphoneNo(), "Aman", "Aman");
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveNewVisitorMovDet(VisitorMovDet visitorMovDet) {
		String sql = "INSERT INTO `corp_vms`.`visitor_mov_det` (`v_id`, `V_organization`, `v_purpose`, `v_meeting_person`, `v_electronic_device`, `created_by`, `updated_by`,`check_in_time` ) VALUES(?,?,?,?,?,?,?,?);";
		jdbc.update(sql, visitorMovDet.getvId(), visitorMovDet.getvOrganzation(), visitorMovDet.getVpurpose(),
				visitorMovDet.getMeetingPerson(), visitorMovDet.getElectronicDevice(), "aman", "aman",
				CommonUtils.getCurrentTime());
		return Boolean.TRUE;
	}

	@Override
	public Boolean visitorCheckOutTime(VisitorDetails VisitorMovDet) {
		String sql = "UPDATE visitor_mov_det \r\n" + "SET \r\n" + "check_out_time = NOW()\r\n" + "WHERE\r\n"
				+ " v_id = '" + VisitorMovDet.getvId() + "'";
		jdbc.update(sql);
		return Boolean.TRUE;
	}

	@Override
	public VisitorDetails visitorSearch(String photoIdNumber) {
		String sql = "SELECT \r\n"
				+ "    visinfo.v_name,visinfo.v_id,visinfo.v_gender,visinfo.photo_id_type,visinfo.photo_id_number,visinfo.age,vismovd.v_electronic_device,vismovd.v_meeting_person,vismovd.v_purpose,vismovd.V_organization\r\n"
				+ "FROM\r\n" + "    visitor_info visinfo\r\n" + "        INNER JOIN\r\n"
				+ "    visitor_mov_det vismovd ON visinfo.v_id = vismovd.v_id\r\n" + "        INNER JOIN\r\n"
				+ "    visitor_address visadd ON visinfo.v_id = visadd.v_id\r\n" + "        INNER JOIN\r\n"
				+ "    visitor_phone vispho ON visinfo.v_id = vispho.v_id\r\n" + "WHERE\r\n"
				+ "    visinfo.photo_id_number = '" + photoIdNumber + "' limit 1;";

		VisitorDetails response = new VisitorDetails();
		response = namedJdbc.query(sql, new ResultSetExtractor<VisitorDetails>() {

			@Override
			public VisitorDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
				VisitorDetails visitor = new VisitorDetails();

				while (rs.next()) {
					visitor.setvName(rs.getString("v_name"));
					visitor.setvGender(rs.getString("v_gender"));
					visitor.setvId(rs.getString("v_id"));
					visitor.setAge(rs.getString("age"));
					visitor.setPhotoIdNumber(rs.getString("photo_id_number"));
					visitor.setPhotoIdType(rs.getString("photo_id_type"));
					visitor.setvOrganzation(rs.getString("V_organization"));
					visitor.setMeetingPerson(rs.getString("v_meeting_person"));
					visitor.setElectronicDevice(rs.getString("v_electronic_device"));
				}
				/**
				 * set visitor address
				 */

				List<VisitorAddress> address = new ArrayList<>();
				String sqlForAddress = "SELECT \r\n" + "    visadd.v_address\r\n" + "    FROM\r\n"
						+ "    visitor_info visinfo\r\n" + "        INNER JOIN\r\n"
						+ "    visitor_mov_det vismovd ON visinfo.v_id = vismovd.v_id\r\n" + "        INNER JOIN\r\n"
						+ "    visitor_address visadd ON visinfo.v_id = visadd.v_id\r\n" + "        INNER JOIN\r\n"
						+ "    visitor_phone vispho ON visinfo.v_id = vispho.v_id\r\n" + "WHERE\r\n"
						+ " visinfo.photo_id_number   = '" + photoIdNumber + "';";

				address = namedJdbc.query(sqlForAddress, new ResultSetExtractor<List<VisitorAddress>>() {
					@Override
					public List<VisitorAddress> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<VisitorAddress> addressRow = new ArrayList<>();

						while (rs.next()) {
							VisitorAddress add = new VisitorAddress();
							add.setVaddress(rs.getString("v_address"));
							addressRow.add(add);
						}
						return addressRow;
					}
				});
				visitor.setVisitorAddress(address);

				/*
				 * set visitor phone no
				 */
				List<VisitorPhoneNo> phone = new ArrayList<>();
				String sqlForPhone = "SELECT \r\n" + "    vispho.v_phone_no\r\n" + "    FROM\r\n"
						+ "    visitor_info visinfo\r\n" + "        INNER JOIN\r\n"
						+ "    visitor_mov_det vismovd ON visinfo.v_id = vismovd.v_id\r\n" + "        INNER JOIN\r\n"
						+ "    visitor_address visadd ON visinfo.v_id = visadd.v_id\r\n" + "        INNER JOIN\r\n"
						+ "    visitor_phone vispho ON visinfo.v_id = vispho.v_id\r\n" + "WHERE\r\n"
						+ " visinfo.photo_id_number   = '" + photoIdNumber + "'";

				phone = namedJdbc.query(sqlForPhone, new ResultSetExtractor<List<VisitorPhoneNo>>() {
					@Override
					public List<VisitorPhoneNo> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<VisitorPhoneNo> phoneRow = new ArrayList<>();
						while (rs.next()) {
							VisitorPhoneNo add = new VisitorPhoneNo();
							add.setphoneNo(rs.getString("v_phone_no"));
							phoneRow.add(add);

						}

						return phoneRow;
					}
				});
				visitor.setVisitorPhoneNo(phone);

				/**
				 * set visitor movement details
				 */

				List<VisitorMovDet> movDet = new ArrayList<>();
				String sqlmovDet = "SELECT \r\n"
						+ "    vismovd.v_id,vismovd.v_purpose,vismovd.v_electronic_device,vismovd.v_meeting_person,vismovd.V_organization,vismovd.check_out_time,vismovd.check_in_time\r\n"
						+ "    FROM\r\n" + "    visitor_info visinfo\r\n" + "        INNER JOIN\r\n"
						+ "    visitor_mov_det vismovd ON visinfo.v_id = vismovd.v_id\r\n" + "        INNER JOIN\r\n"
						+ "    visitor_address visadd ON visinfo.v_id = visadd.v_id\r\n" + "        INNER JOIN\r\n"
						+ "    visitor_phone vispho ON visinfo.v_id = vispho.v_id\r\n" + "WHERE\r\n"
						+ " visinfo.photo_id_number   = '" + photoIdNumber + "'";

				movDet = namedJdbc.query(sqlmovDet, new ResultSetExtractor<List<VisitorMovDet>>() {
					@Override
					public List<VisitorMovDet> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<VisitorMovDet> movDetRow = new ArrayList<>();

						while (rs.next()) {
							VisitorMovDet add = new VisitorMovDet();
							add.setvId(rs.getInt("v_id"));
							add.setVpurpose(rs.getString("v_purpose"));
							add.setvOrganzation(rs.getString("V_organization"));
							add.setMeetingPerson(rs.getString("v_meeting_person"));
							add.setElectronicDevice(rs.getString("v_electronic_device"));
							add.setCheckInTime(rs.getString("check_in_time"));
							add.setCheckOutTime(rs.getString("check_out_time"));
							movDetRow.add(add);
						}
						return movDetRow;
					}
				});
				visitor.setVisitorMovDet(movDet);

				return visitor;
			}
		});
		return response;
	}

	@Override
	public Boolean getVisitorCountByVId(String vId) {
		String sql = "select count(*) from corp_vms.visitor_info where v_id='" + vId + "';";
		int count = jdbc.queryForObject(sql, Integer.class);
		if (count > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean getVisitorCountByPhoneNo(List<VisitorPhoneNo> list) {
		List<String> phoneNoList = new ArrayList<>();
		for (VisitorPhoneNo phoneNo : list) {
			phoneNoList.add(phoneNo.getphoneNo());
		}
		Map<String, List<String>> map = new HashMap<>();
		map.put("phoneNoList", phoneNoList);
		String sql = "select count(*) from corp_vms.visitor_phone where v_phone_no in (:phoneNoList);";
		int count = namedJdbc.queryForObject(sql, map, Integer.class);
		if (count > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean getVisitorCountByAddress(List<VisitorAddress> list) {
		List<String> addressList = new ArrayList<>();
		for (VisitorAddress address : list) {
			addressList.add(address.getVaddress());
		}
		Map<String, List<String>> map = new HashMap<>();
		map.put("addressList", addressList);
		String sql = "SELECT count(*) FROM corp_vms.visitor_address where v_address in (:addressList);";
		int count = namedJdbc.queryForObject(sql, map, Integer.class);
		if (count > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;

	}

	@Override
	public List<VisitorReoprt> visitorReportByDate(VisitorReportRequest visitorReportRequest) {
		/**
		 * visitor get report
		 */
		List<VisitorReoprt> visitorReport = new ArrayList<>();
		String sqlForVisitor = "SELECT \r\n"
				+ "  vispho.v_phone_no, vismovd.v_meeting_person,vismovd.v_purpose,vismovd.V_organization,visinfo.v_name\r\n"
				+ "FROM\r\n" + "    visitor_info visinfo\r\n" + "        INNER JOIN\r\n"
				+ "    visitor_mov_det vismovd ON visinfo.v_id = vismovd.v_id\r\n" + "        INNER JOIN\r\n"
				+ "    visitor_address visadd ON visinfo.v_id = visadd.v_id\r\n" + "        INNER JOIN\r\n"
				+ "    visitor_phone vispho ON visinfo.v_id = vispho.v_id\r\n" + "where vismovd.created_date between '"
				+ visitorReportRequest.getFromDate() + "' and '" + visitorReportRequest.getToDate() + "';";

		visitorReport = namedJdbc.query(sqlForVisitor, new ResultSetExtractor<List<VisitorReoprt>>() {

			@Override
			public List<VisitorReoprt> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<VisitorReoprt> visitorRow = new ArrayList<>();
				while (rs.next()) {
					VisitorReoprt report = new VisitorReoprt();
					report.setMeetingPerson(rs.getString("v_meeting_person"));
					report.setPurposeVisit(rs.getString("v_purpose"));
					report.setvName(rs.getString("v_name"));
					report.setvOrganzation(rs.getString("V_organization"));
					report.setvPhone(rs.getString("v_phone_no"));
					visitorRow.add(report);

				}
				return visitorRow;
			}

		});
		return visitorReport;
	}

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */

	@Override
	public Boolean countByEmployeeId(String employeeId) {
		String sql = "select count(*) from empolyee.employee_details where employee_id='" + employeeId + "'";
		int count = jdbc.queryForObject(sql, Integer.class);
		if (count > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public int saveEmployeeDeatils(EmployeeDetails employeeDetails) {
		String sql = "INSERT INTO `empolyee`.`employee_details` (`employee_id`, `first_name`, `last_name`, `email_id`, `id_proof`, `id_proof_number`, `age`, `gender`, `pervious_organization`,  `created_by`, `updated_by`,`check_in_time`,`check_out_time`) VALUES (?,?,?,?,?, ?, ?, ?, ?, ?, ?,now(),?);";
		GeneratedKeyHolder matIdHolder = new GeneratedKeyHolder();
		jdbc.update((Connection con) -> {
			PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, employeeDetails.getEmployeeId());
			preparedStatement.setString(2, employeeDetails.getFirstName());
			preparedStatement.setString(3, employeeDetails.getLastName());
			preparedStatement.setString(4, employeeDetails.getEmailId());
			preparedStatement.setString(5, employeeDetails.getIdProof());
			preparedStatement.setString(6, employeeDetails.getIdProofNumber());
			preparedStatement.setString(7, employeeDetails.getAge());
			preparedStatement.setString(8, employeeDetails.getGender());
			preparedStatement.setString(9, employeeDetails.getPerviousOrganization());
			preparedStatement.setString(10, ("aman"));
			preparedStatement.setString(11, ("aman"));
			preparedStatement.setString(12, employeeDetails.getCheckOutTime());
			return preparedStatement;
		}, matIdHolder);
		return matIdHolder.getKey().intValue();

	}

	@Override
	public Boolean saveEmployeeAddress(EmployeeAddressDetails employeeAddress) {
		String sql = "INSERT INTO `empolyee`.`employee_address_details` (`employee_id`, `employee_address`) VALUES (?, ?);";
		jdbc.update(sql, employeeAddress.getEmployeeId(), employeeAddress.getEmployeeAddress());
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveEmployeeContact(EmployeeContactDetails contactDetails) {
		String sql = "INSERT INTO `empolyee`.`employee_contact_details` (`employee_id`, `phone_number`) VALUES (?,?);";
		jdbc.update(sql, contactDetails.getEmployeeId(), contactDetails.getPhoneNumber());
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveHrDepartement(HrDepartmentDetails hrDepartmentDetails) {
		String sql = "INSERT INTO `empolyee`.`hr_department_details` (`employee_id`, `hire_date`) VALUES (?, ?);";
		jdbc.update(sql, hrDepartmentDetails.getEmployeeId(), hrDepartmentDetails.getHireDate());
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveTransportDetails(TransportDetails transportDetails) {
		String sql = "INSERT INTO `empolyee`.`transport_details` (`employee_id`, `take_cab_date`, `cab__info`,`destination`,`driver_name`,`employee_department`,`from_destination`) VALUES (?, now(), ?,?,?,?,?);";
		jdbc.update(sql, transportDetails.getEmployeeId(), transportDetails.getCabInfo(),
				transportDetails.getDestination(), transportDetails.getDriverName(),
				transportDetails.getEmployeeDepartment(), transportDetails.getFromDestination());
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveEmployeeProjectSalary(EmployeeProjectSalary employeeProjectSalary) {
		String sql = "INSERT INTO `empolyee`.`employee_project_salary` (`employee_id`, `project_id`, `salary_id`) VALUES (?, ?, ?);";
		jdbc.update(sql, employeeProjectSalary.getEmployeeId(), employeeProjectSalary.getProjectId(),
				employeeProjectSalary.getSalaryId());
		return Boolean.TRUE;
	}

	@Override
	public List<EmployeeReport> saveEployeeReport(EmployeeRequest employeeRequest) {

		List<EmployeeReport> empReport = new ArrayList<>();
		String sql = "select first_name ,last_name,email_id,gender,id_proof,check_in_time,check_out_time\r\n" + 
				"from empolyee.employee_details\r\n" + 
				"where employee_id='"+employeeRequest.getEmployeeId()+"'";

		empReport = namedJdbc.query(sql, new ResultSetExtractor<List<EmployeeReport>>() {

			@Override
			public List<EmployeeReport> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<EmployeeReport> employee = new ArrayList<>();
				while (rs.next()) {
					EmployeeReport report = new EmployeeReport();
					report.setFirstName(rs.getString("first_name"));
					report.setLastName(rs.getString("last_name"));
					report.setEmailId(rs.getString("email_id"));
					report.setGender(rs.getString("gender"));
					report.setIdProof(rs.getString("id_proof"));
					report.setCheckInTime(rs.getString("check_in_time"));
					report.setCheckOutTime(rs.getString("check_out_time"));

					employee.add(report);
				}
				return employee;
			}

		});
		return empReport;
	}

	@Override
	public EmployeeDetails saveEmployeeInfo(String employeeId) {
		String sql = "SELECT employee_id,first_name,last_name,email_id,id_proof,pervious_organization\r\n"
				+ "FROM empolyee.employee_details\r\n" + "where employee_id='" + employeeId + "';";

		EmployeeDetails response = new EmployeeDetails();
		response = namedJdbc.query(sql, new ResultSetExtractor<EmployeeDetails>() {

			@Override
			public EmployeeDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
				EmployeeDetails response = new EmployeeDetails();

				while (rs.next()) {
					response.setEmployeeId(rs.getString("employee_id"));
					response.setFirstName(rs.getString("first_name"));
					response.setLastName(rs.getString("last_name"));
					response.setEmailId(rs.getString("email_id"));
					response.setIdProof(rs.getString("id_proof"));
					response.setPerviousOrganization(rs.getString("pervious_organization"));

				}
				return response;
			}
		});
		return response;

	}

	@Override
	public Boolean saveEployeeLeveJob(EmployeeDetails hrEmployeeDetails) {
		String sql = "update empolyee.hr_department_details set leve_job_date=now()\r\n" + "where employee_id='"
				+ hrEmployeeDetails.getEmployeeId() + "'";
		jdbc.update(sql);
		return Boolean.TRUE;
	}

	@Override
	public Boolean svaeEmployeeCheckOut(EmployeeDetails employeeDetails) {
		String sql = "update  empolyee.employee_details\r\n" + "set  check_out_time=now() where employee_id='"
				+ employeeDetails.getEmployeeId() + "'";
		jdbc.update(sql); 
		return Boolean.TRUE;
	}

	@Override
	public List<EmpolyeeSalaryProjectInformation> employeeInformation() {
		String sql = "SELECT id ,project_name from empolyee.project;\r\n" + "";
		List<EmpolyeeSalaryProjectInformation> response = new ArrayList<>();
		response = namedJdbc.query(sql, new ResultSetExtractor<List<EmpolyeeSalaryProjectInformation>>() {

			@Override
			public List<EmpolyeeSalaryProjectInformation> extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				List<EmpolyeeSalaryProjectInformation> role = new ArrayList<>();

				while (rs.next()) {
					EmpolyeeSalaryProjectInformation newRole = new EmpolyeeSalaryProjectInformation();
					newRole.setId(rs.getString("id"));
					newRole.setProjectName(rs.getString("project_name"));

					role.add(newRole);
				}
				return role;
			}
		});
		return response;
	}

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */

	@Override
	public Boolean countByCustomerId(String customerId) {
		String sql = "select count(*) FROM product_suppllier.customer_details\r\n" + "where customer_id='" + customerId
				+ "'";
		int count = jdbc.queryForObject(sql, Integer.class);
		if (count > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;

	}

	@Override
	public int saveCustomerDetails(CustomerDetails customerDetails) {
		String sql = "INSERT INTO `product_suppllier`.`customer_details` (`customer_id`, `customer_name`, `shop_name`, `shop_id`, `created_by`, `updated_by`) VALUES (?,?, ?,?, ?,?);";
		GeneratedKeyHolder matIdHolder = new GeneratedKeyHolder();
		jdbc.update((Connection con) -> {
			PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, customerDetails.getCustomerId());
			preparedStatement.setString(2, customerDetails.getCustomerName());
			preparedStatement.setString(3, customerDetails.getShopName());
			preparedStatement.setString(4, customerDetails.getShopId());
			preparedStatement.setString(5, ("aman"));
			preparedStatement.setString(6, ("aman"));
			return preparedStatement;
		}, matIdHolder);
		return matIdHolder.getKey().intValue();

	}

	@Override
	public Boolean saveCustomerAddress(CustomerAddress customerAddress) {
		String sql = "INSERT INTO `product_suppllier`.`customer_address` (`customer_id`, `address`, `created_by`, `updated_by`) VALUES (?, ?, 'aman', 'aman');";
		jdbc.update(sql, customerAddress.getCustomerId(), customerAddress.getAddress());
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveContactNumber(CustomerContactDetails customerContactDetails) {
		String sql = "INSERT INTO `product_suppllier`.`customer_contact_details` (`customer_id`, `phone_number`, `created_by`, `updated_by`) VALUES (?, ?, 'aman', 'aman');";
		jdbc.update(sql, customerContactDetails.getCustomerId(), customerContactDetails.getPhoneNumber());
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveOrderItem(OrderItem orderItem) {
		String sql = "INSERT INTO `product_suppllier`.`order_item` (`customer_id`, `itme_quntity`, `total_item`, `total_amount`, `created_by`, `updated_by`) VALUES (?, ?, ?, ?, 'aman', 'aman');";
		jdbc.update(sql, orderItem.getCustomerId(), orderItem.getItmeQuntity(), orderItem.getTotalItem(),
				orderItem.getTotalAmount());
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveOrderMatrial(OrderMatrial orderMatrial) {
		String sql = "INSERT INTO `product_suppllier`.`order_matrial` (`customer_id`, `order_number`, `order_date`, `order_id`, `total_order`, `created_by`, `updated_by`) VALUES (?, ?, ?, ?,?, 'aman', 'aman');";
		jdbc.update(sql, orderMatrial.getCustomerId(), orderMatrial.getOrderNumber(), orderMatrial.getOrderDate(),
				orderMatrial.getOrderId(), orderMatrial.getTotalOrder());
		return Boolean.TRUE;

	}

	@Override
	public Boolean saveProduct(Product product) {
		String sql = "INSERT INTO `product_suppllier`.`product` (`customer_id`, `product_company_name`, `product_mf_date`, `product_exp_date`, `product_price`, `created_by`, `updated_by`) VALUES (?, ?, ?, ?, ?, 'aman', 'aman');";
		jdbc.update(sql, product.getCustomerId(), product.getProductCompanyName(), product.getProductMfDate(),
				product.getProductExpDate(), product.getProductPrice());
		return Boolean.TRUE;
	}

	@Override
	public Boolean countBySupplierrId(String supplierId) {
		String sql = "select count(*) from product_suppllier.supplier_details\r\n" + "where supplier_id='" + supplierId
				+ "'";
		int count = jdbc.queryForObject(sql, Integer.class);
		if (count > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean saveSupplierDetails(SupplierDetails supplierDetails) {
		String sql = "INSERT INTO `product_suppllier`.`supplier_details` (`customer_id`, `supplier_id`, `supplier_name`, `country_name`, `city_name`, `created_by`, `updated_by`) VALUES (?, ?, ?, ?, ?, 'aman', 'aman');";
		jdbc.update(sql, supplierDetails.getCustomerId(), supplierDetails.getSupplierId(),
				supplierDetails.getSupplierName(), supplierDetails.getCountryName(), supplierDetails.getCityName());
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveSupplierAddress(SupplierAddress supplierAddress) {
		String sql = "INSERT INTO `product_suppllier`.`supplier_address` (`supplier_id`, `supplier_address`, `created_by`, `updated_by`) VALUES (?,?, 'aman', 'aman');";
		jdbc.update(sql, supplierAddress.getSupplierId(), supplierAddress.getSupplierAddress());
		return Boolean.TRUE;
	}

	@Override
	public Boolean saveSuppplierContact(SupplierContactDetails supllierContactDetails) {
		String sql = "INSERT INTO `product_suppllier`.`supplier_contact_number` (`supplier_id`, `phone_number`, `created_by`, `updated_by`) VALUES (?, ?, 'aman', 'aman');";
		jdbc.update(sql, supllierContactDetails.getSupplierId(), supllierContactDetails.getPhoneNumber());
		return Boolean.TRUE;
	}

}
