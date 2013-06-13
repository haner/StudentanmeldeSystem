/**
 * 
 */
package spring.webapp.loginsystem.persistence.dao;

import spring.webapp.loginsystem.entity.User;

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
