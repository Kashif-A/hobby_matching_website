package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", updatable = false, nullable = false)
	int user_id;
	@Column(name="username")
	String username;
	@Column(name="first_name")
	int first_name;
	@Column(name="last_name")
	String last_name;
	@Column(name="gender")
	String gender;
	@Column(name="password")
	String password;
	@Column(name="status")
	String status;
	
	public User() {};
	
	public User(String username, int first_name, String last_name, String gender, String password) {
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.password = password;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getFirst_name() {
		return first_name;
	}
	public void setFirst_name(int first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", first_name=" + first_name + ", last_name="
				+ last_name + ", gender=" + gender + ", password=" + password + ", status=" + status + "]";
	}
	
}
