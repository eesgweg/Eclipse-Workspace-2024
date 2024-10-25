package InterviewPractice;

import java.util.List;

public class UserDetails {
	
	private int userId;
	private String userName;
	private ContactInfo contactInfo;
	private List<Roles> roles;
	private boolean active;
	
	UserDetails(int userId,String userName,ContactInfo contactInfo,List<Roles> roles,boolean active){
		this.userId=userId;
		this.userName=userName;
		this.contactInfo=contactInfo;
		this.roles=roles;
		this.active=active;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the contactInfo
	 */
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	/**
	 * @param contactInfo the contactInfo to set
	 */
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	/**
	 * @return the roles
	 */
	public List<Roles> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return Date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		Date = date;
	}
	private String Date;

}
