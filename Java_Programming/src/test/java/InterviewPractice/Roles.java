package InterviewPractice;

import java.util.List;

public class Roles {
	private String role;
	private List<String> permissions;
	public Roles(String role,List<String> permissions) {
		this.role=role;
		this.permissions=permissions;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	
	public List<String> getPermissions() {
		return permissions;
	}

	
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
}
