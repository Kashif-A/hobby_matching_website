package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.User;

public class UserDAOTest {
	
	UserDAO userDAO = new UserDAO();

	/* @Test
	public void testListUsers() {
		User testUser = new User("test","test","test","test");
		testUser.setUser_id(1);
		List<User> userList = userDAO.listUsers();
		User actualUser = userList.get(0);
		
		assertEquals(testUser.getUser_id(), actualUser.getUser_id());
		assertEquals(testUser.getFirst_name(), actualUser.getFirst_name());
		assertEquals(testUser.getLast_name(), actualUser.getLast_name());
		assertEquals(testUser.getGender(), actualUser.getLocation());
	}

	@Test
	public void testGetUser() {
		User testUser = new User("test","test","test","test");
		testUser.setUser_id(1);
		User actualUser = userDAO.getUser(1);
		
		assertEquals(testUser.getUser_id(), actualUser.getUser_id());
		assertEquals(testUser.getFirst_name(), actualUser.getFirst_name());
		assertEquals(testUser.getLast_name(), actualUser.getLast_name());
		assertEquals(testUser.getGender(), actualUser.getLocation());
	}

	@Test
	public void testGetHobbies() {
		fail("Not yet implemented");
	} */

	@Test
	public void testAddUser() {
		User testUser = new User("test","test","test","test");
		testUser.setUser_id(5);
		testUser.setUsername(2);
		userDAO.addUser(testUser);
		User addedUserFromDB = userDAO.getUser(5);
		
		assertEquals(testUser.getUser_id(), addedUserFromDB.getUser_id());
		assertEquals(testUser.getFirst_name(), addedUserFromDB.getFirst_name());
		assertEquals(testUser.getLast_name(), addedUserFromDB.getLast_name());
		assertEquals(testUser.getGender(), addedUserFromDB.getLocation());
	}

	/*@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}*/

}
