package com.basic.app.security;

import org.springframework.security.core.GrantedAuthority;

public class Authorities implements GrantedAuthority{ 
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	 *  
	 */ 
	 
	private String authority;
	 
	public Authorities(String authority) {
		this.authority = authority;
	} 
 
	public Authorities() { 
		super(); 
	} 
 
	public void setAuthority(String authority) {
		this.authority = authority;
	} 
 
	@Override 
	public String getAuthority() {
		return this.authority;
	} 
 
} 