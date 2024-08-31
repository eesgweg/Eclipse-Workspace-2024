package POJOPractice;

import java.util.List;

public class MainDetails {
private int id;
private String name;
private String email;
private Address address;
private List<PhoneNumbers> phoneNumbers;
private List<String> roles;
private Boolean active;
private String createdDate;
private String lastLogin;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public List<PhoneNumbers> getPhoneNumbers() {
	return phoneNumbers;
}
public void setPhoneNumbers(List<PhoneNumbers> phoneNumbers) {
	this.phoneNumbers = phoneNumbers;
}
public List<String> getRoles() {
	return roles;
}
public void setRoles(List<String> roles) {
	this.roles = roles;
}
public Boolean getActive() {
	return active;
}
public void setActive(Boolean active) {
	this.active = active;
}
public String getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(String createdDate) {
	this.createdDate = createdDate;
}
public String getLastLogin() {
	return lastLogin;
}
public void setLastLogin(String lastLogin) {
	this.lastLogin = lastLogin;
}


}
