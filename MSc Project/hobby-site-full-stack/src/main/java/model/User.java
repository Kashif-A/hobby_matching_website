package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="user_detail")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int user_id;
	@Column(name="username")
	private int username;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="gender")
	private String gender;
	@Column(name="location")
	private String location;
	@Column(name="_status")
	private String status;
	@Column(name="profile_img")
	private String profile_img;
	@Transient
	private List<String> hobbies;
	
	public User() {}

	public User(String first_name, 
				String last_name, 
				String gender,
				String location) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.location = location;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	
	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", first_name=" + first_name + ", last_name="
				+ last_name + ", gender=" + gender + ", location=" + location + ", status=" + status + ", profile_img="
				+ profile_img + ", hobbies=" + hobbies + "]";
	}

}
