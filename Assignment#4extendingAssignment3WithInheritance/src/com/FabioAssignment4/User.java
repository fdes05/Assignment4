package com.FabioAssignment4;

public class User implements Comparable<User>{
	
	private String username;
	private String password;
	private String name;
	private String role;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int compareTo(User that) {
	
		if (this.role.contains("super_user") && that.role.contains("super_user")) {
			return this.username.compareTo(that.username);
		} else if (this.role.contains("normal_user") && that.role.contains("normal_user")) {
			return this.username.compareTo(that.username);
		} return 1;
				
	}
}
