package com.mediasoft.odeks.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {
	private Authentication authentification;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	public UserPrincipal(User user) {
		super();
		this.user = user;

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAutorithy = new ArrayList<GrantedAuthority>();
		for (int i = 0; i < this.user.getRoles().size(); i++) {
			SimpleGrantedAuthority granted = new SimpleGrantedAuthority(user.getRoles().get(i).getRoleName());
			grantedAutorithy.add(granted);
		}
		return grantedAutorithy;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getName();
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

	public Authentication getAuthentification() {
		return authentification;
	}

	public void setAuthentification(Authentication authentification) {
		this.authentification = authentification;
	}

	@Override
	public int hashCode() {
		return this.user.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		UserPrincipal principal = (UserPrincipal) obj;
		return this.user.equals(principal.user);
	}

	public void addRole(Role role) {
		this.user.getRoles().add(role);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
