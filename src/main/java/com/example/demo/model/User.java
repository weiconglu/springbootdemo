package com.example.demo.model;

public class User {

	public String userName;
	public String gender;
	public String address;

	public Dog dog;

	@Override
	public String toString() {
		return "User [userName=" + userName + ", gender=" + gender + ", address=" + address + ", dog=" + dog + "]";
	}

}
