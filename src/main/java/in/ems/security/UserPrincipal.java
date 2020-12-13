package in.ems.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import in.ems.model.User;
import in.ems.utils.CommonUtils;

public class UserPrincipal implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	private String userId;
	@JsonIgnore
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserPrincipal(String userId, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.userId = userId;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static UserPrincipal create(User user) {
		List<GrantedAuthority> authorities = CommonUtils.newArrayListInstance();
		/*
		 * List of authorities can be fetched from database which eases the API routing
		 * access, for current use case only single authority hence added manually in
		 * code.
		 */
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new UserPrincipal(user.getUserId(), user.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
}
