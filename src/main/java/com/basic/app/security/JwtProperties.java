package com.basic.app.security;

public class JwtProperties { 
	 
	private final long jwtExpirationTime = 1000*60*40;
	 
	private final String jwtSecret = "MaozcaptionitSuperSecret";
	 
	private final String jwtSchema = "Bearer";
	 
	private final String jwtHeader = "api-token";
	 
//	private final String salt = KeyGenerators.string().generateKey(); 
	private final String salt = "8cbe18295de55596";
	 
	public String getSalt() {
		return salt;
	} 
	 
	public long getJwtExpirationTime() { 
		return jwtExpirationTime;
	} 
 
	public String getJwtSecret() {
		return jwtSecret;
	} 
 
	public String getJwtSchema() {
		return jwtSchema;
	} 
 
	public String getJwtHeader() {
		return jwtHeader;
	} 
} 