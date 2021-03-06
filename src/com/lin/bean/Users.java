package com.lin.bean;


public class Users {
		//用戶名
		private String username;
		//密碼
		private String password;
		//姓名
		private String name;
		//手机号码
		private String phoneNumber;
		//地址
		private String address;
		//邮箱
		private String email;
		
		public Users() {
			super();
		}
		public Users(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		public Users(String username, String password, String name, String phoneNumber, String address, String email) {
			super();
			this.username = username;
			this.password = password;
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.email = email;
		}
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
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String adress) {
			this.address = adress;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Override
		public String toString() {
			return "Users [username=" + username + ", password=" + password + ", name=" + name + ", phoneNumber="
					+ phoneNumber + ", address=" + address + ", email=" + email + "]";
		}
		
		
		
}
