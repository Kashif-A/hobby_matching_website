package dao;

import java.util.List;

import model.User;

/**
 * UserDAO Interface.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   June 2019
 */
public interface UserDAO {

	   /**
	    * This method lists all films.
	    * 
	    * @return List<Film> collection containing all films.
	    */
	    public List<User> listUsers();
	    
	    /**
	     * This method gets specific film based on search criteria.
	     * 
	     * @param searchCriteria search by ID, title, year etc.
	     * @param searchString String used for searching film.
	     * @return List<Film> collection containing all films matching search criteria.
	     */
	    public List<User> getUser(int userID);
	    
	    /**
	     * This method adds a film to database.
	     * 
	     * @param film Film object to be added
	     */
	    public void addUser(User user);
	    
	    /**
	     * This method updates a film based on ID.
	     * 
	     * @param film updated film object to replace old film.
	     * @param id of the film to be updated.
	     */
	    public void updateUser(User user, int id);
	    
	    /**
	     * Delete film based on ID.
	     * 
	     * @param id of the film to be deleted.
	     * @return String object letting user know if film successfully deleted or not.
	     */
	    public String deleteUser(int id);
	    
}