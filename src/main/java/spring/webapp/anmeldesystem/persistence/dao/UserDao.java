/**
 * 
 */
package spring.webapp.anmeldesystem.persistence.dao;

import spring.webapp.anmeldesystem.entity.User;

/**
 * @author Songhua Cui
 * 
 * 
 */
public interface UserDao {

	/**
	 * @param email
	 * @return {@link User}
	 */	
    User searchUserByEmail(String email) ;
}
