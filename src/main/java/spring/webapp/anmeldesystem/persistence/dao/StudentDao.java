/**
 * 
 */
package spring.webapp.anmeldesystem.persistence.dao;

import spring.webapp.anmeldesystem.entity.Student;

/**
 * @author Songhua Cui
 * 
 * 
 */
public interface StudentDao {

	/**
	 * @param email
	 * @return 
	 */
	Student getStudentbyEmail(String email);
	
	/**
	 * @param id
	 * @return 
	 */
	Student getStudentById(long id);

	/**
	 * @param id
	 * @return 
	 */
	Student getStudentInfosById(long id);
}
