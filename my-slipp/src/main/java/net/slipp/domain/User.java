package net.slipp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long Id;
	@Column(nullable=false, length=20, unique=true)
	private String userId;
	private String userPw;
	private String userEmail;
	private String userName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", userId=" + userId + ", userPw=" + userPw + ", userEmail=" + userEmail
				+ ", userName=" + userName + "]";
	}

	public void update(User newUser) {
		// TODO Auto-generated method stub
		this.userPw = newUser.userPw;
		this.userEmail = newUser.userEmail;
		this.userName = newUser.userName;
	}
}
