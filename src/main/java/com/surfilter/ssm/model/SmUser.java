package com.surfilter.ssm.model;

public class SmUser {

	private Integer userId;
	
	private String userName;
	
	private String userType;
	
	private String mail;
	
	private String address;
	
	private String phone;
	
	private String userPic;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	@Override
	public String toString() {
		return "SmUser [userId=" + userId + ", userName=" + userName + ", userType=" + userType + ", mail=" + mail
				+ ", address=" + address + ", phone=" + phone + ", userPic=" + userPic + "]";
	}
	
	
}
