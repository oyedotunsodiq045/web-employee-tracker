package com.soyedotun.web.jdbc;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String department;
	private String email;
	private String phoneNumber;
	private String password;
	private String designation;
	private String address;
	private String dor;
	
	public Employee(String firstName, String lastName, String username, String department, String email,
			String phoneNumber, String password, String designation, String address, String dor) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.department = department;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.designation = designation;
		this.address = address;
		this.dor = dor;
	}
	
	public Employee(int id, String firstName, String lastName, String username, String department, String email,
			String phoneNumber, String password, String designation, String address, String dor) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.department = department;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.designation = designation;
		this.address = address;
		this.dor = dor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDor() {
		return dor;
	}
	public void setDor(String dor) {
		this.dor = dor;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", department=" + department + ", email=" + email + ", phoneNumber=" + phoneNumber + ", password="
				+ password + ", designation=" + designation + ", address=" + address + ", dor=" + dor + "]";
	}
	
	
}
