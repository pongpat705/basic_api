package com.basic.app.model;

import java.util.ArrayList;
import java.util.List;

public class UserProfile {

	private String name;
	private List<String> permission;
	public UserProfile() {
		
		name = null;
		permission = new ArrayList<>();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPermission() {
		return permission;
	}
	public void setPermission(List<String> permission) {
		this.permission = permission;
	}
}
