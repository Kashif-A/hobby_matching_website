package model;

import java.util.Arrays;

public class JsonRegisterForm {

	private String uname;
	private String password;
	private String fname;
	private String lname;
	private String location;
	private String[] hobbies;
	
	public JsonRegisterForm(String uname, String password, String fname, String lname, String location,
			String[] hobbies) {
		super();
		this.uname = uname;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.location = location;
		this.hobbies = hobbies;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "JsonRegisterForm [uname=" + uname + ", password=" + password + ", fname=" + fname + ", lname=" + lname
				+ ", location=" + location + ", hobbies=" + Arrays.toString(hobbies) + "]";
	}
	

}

