package com.yash.pro1.baramatiAtm;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class empinfo {

		@Id
		private int user_id;
		
		private String userName;
		
		private String userEmail;
		
		private int userPassword;

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}

		public int getUserPassword() {
			return userPassword;
		}

		public void setUserPassword(int userPassword) {
			this.userPassword = userPassword;
		}

		@Override
		public String toString() {
			return "empinfo [user_id=" + user_id + ", userName=" + userName + ", userEmail=" + userEmail
					+ ", userPassword=" + userPassword + "]";
		}
		
		
		
}
