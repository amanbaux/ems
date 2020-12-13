package in.ems.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ems.model.MemberDetails;
import in.ems.model.MemberReport;
import in.ems.model.MembershipInformation;
import in.ems.model.StudentDetails;
import in.ems.model.UserDetails;
import in.ems.model.UserRoleInfomation;
import in.ems.repository.UserRepository;
import in.ems.request.LoginRequest;
import in.ems.request.MemberRequestReport;
import in.ems.response.ApiResponse;
import in.ems.response.JwtAuthenticationResponse;
import in.ems.security.JwtTokenProvider;
import in.ems.services.AuthService;
import in.ems.utils.GmsCustomException;
import in.ems.utils.SisCustomException;
import in.ems.utils.VmsCustomException;

@RestController
@RequestMapping("/ems/auth")
public class AuthController { 

	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	AuthenticationManager authManager; 

	@Autowired 
	PasswordEncoder passEncoder; 
 
	@Autowired 
	UserRepository userRepo; 

	@Autowired
	JwtTokenProvider tokenProvider; 

	@Autowired
	AuthService authService; 

	@Validated

	@PostMapping("/login")  
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) throws SQLException {
		/*
		 * SecurityContext holds the authentication details of user in form of
		 * "UserPrincipal"
		 */
		LOG.info(request.getUserId());
		Authentication authentication = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUserId(), request.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		LOG.info("************Authorities**************");
		LOG.info(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, "Successfully authenticated", "0",
				userRepo.findByName(request.getUserId()).getRole().toString()));
	}

	@PostMapping("/register-new-user")
	public ResponseEntity<?> register(@Valid @RequestBody UserDetails request) {
		ApiResponse response = new ApiResponse();
		try {
			System.out.println("------------------" + request.toString());
			request.setPassword(passEncoder.encode(request.getPassword()));
			Boolean status = authService.saveUserDetails(request);
			if (status) {
				response.setErrorCode("0");
				response.setMessageText("User registered successfully.");
			}
			return new ResponseEntity(response, HttpStatus.OK);
		}

		catch (VmsCustomException ex) {
			response.setErrorCode(ex.getErrorCode());
			response.setMessageText(ex.getMessageText());
			return new ResponseEntity(response, HttpStatus.OK); 
		}

		catch (Exception e) {
			response.setErrorCode("400"); 
			response.setMessageText(e.getLocalizedMessage()); 
			return new ResponseEntity(response, HttpStatus.OK); 
		}

	} 

	@GetMapping("/user-role-search") 
	public ResponseEntity<?> userRoleSearch() {
		System.out.println("user role");
		List<UserRoleInfomation> userRoleInfomation = authService.userRoleSearch();
		return new ResponseEntity(userRoleInfomation, HttpStatus.OK);
	}

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 
	 * @param request
	 * @return
	 */
 
	@PostMapping("/student-registration")
	public ResponseEntity<?> registerSudent(@Valid @RequestBody StudentDetails request) {
		ApiResponse response = new ApiResponse();
		try {
			System.out.println("+++++++++++++" + request.toString());
			Boolean status = authService.saveStudentDetails(request);
			if (status) {
				response.setErrorCode("0");
				response.setMessageText("Student Registration Successfully");
			}
			return new ResponseEntity(response, HttpStatus.OK);
		} catch (SisCustomException ex) {
			response.setErrorCode(ex.getErrorCode());
			response.setMessageText(ex.getMessageText());
			return new ResponseEntity(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setErrorCode("400");
			response.setMessageText(e.getLocalizedMessage());
			return new ResponseEntity(response, HttpStatus.OK);
		}
	}

	@GetMapping("/student-search")
	public ResponseEntity<?> studentSearch(@RequestParam("studentId") String studentId) {
		System.out.println("studentId===============" + studentId);
		StudentDetails student = authService.studentSearch(studentId);
		return new ResponseEntity(student, HttpStatus.OK);
	}

	@PostMapping("/student-check-out") 
	public ResponseEntity<?> studentCheckOut(@Valid @RequestBody StudentDetails request) {
		ApiResponse response = new ApiResponse();
		System.out.println("student check out" + request.toString());
		Boolean status = authService.studentCheckOut(request);
		if (status) {
			response.setErrorCode("0");
			response.setMessageText("student Checked Out Successfully");
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}

	/**
	 * here gms code
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */

	@PostMapping("/member-registration-form")
	public ResponseEntity<?> memberRegistration(@Valid @RequestBody MemberDetails request) {

		ApiResponse response = new ApiResponse();
		try {
			System.out.println("++++++++++++++++++++" + request.toString());
			Boolean status = authService.saveMemberDetails(request);
			if (status) {
				response.setErrorCode("0");
				response.setMessageText("memebr register successfully");
			}

			return new ResponseEntity(response, HttpStatus.OK);
		}

		catch (GmsCustomException ex) {
			ex.printStackTrace();
			response.setErrorCode(ex.getErrorCode());
			response.setMessageText(ex.getMessageText());
			return new ResponseEntity(response, HttpStatus.OK);
		}

		catch (Exception e) {
			e.printStackTrace();
			response.setErrorCode("400");
			response.setMessageText(e.getLocalizedMessage());
			return new ResponseEntity(response, HttpStatus.OK);
		}
	}

	@GetMapping("/member-search")
	public ResponseEntity<?> memberSearch(@RequestParam("memberId") String memberId) {
		System.out.println("member Id++++++++++++++++++++++++" + memberId);
		MemberDetails details = authService.memberSearch(memberId);
		return new ResponseEntity(details, HttpStatus.OK);
	}

	@PostMapping("/member-report-by-memberid")
	public ResponseEntity<?> memberReport(@Valid @RequestBody MemberRequestReport request) {
		ApiResponse response = new ApiResponse();
		System.out.println("------------------" + request.toString());
		List<MemberReport> status = authService.memberReport(request);
		if (status != null) {
			response.setErrorCode("0");
			response.setMessageText("report found successfully");
		}
		return new ResponseEntity(status, HttpStatus.OK);
	}

	@PostMapping("/member-check-out")
	public ResponseEntity<?> memberCheckOut(@Valid @RequestBody MemberDetails request) {
		ApiResponse response = new ApiResponse();
		System.out.println("member check out+++++++++++++++++" + request.toString());
		Boolean status = authService.memberCheckOut(request);
		if (status) {
			response.setErrorCode("0");
			response.setMessageText("member check out successfully");
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}

	@GetMapping("/member-membership-search")
	public ResponseEntity<?> memberRoleSearch() {
		System.out.println("member role");
		List<MembershipInformation> membershipInformations = authService.memberRoleSearch();
		return new ResponseEntity(membershipInformations, HttpStatus.OK);
	}

}
