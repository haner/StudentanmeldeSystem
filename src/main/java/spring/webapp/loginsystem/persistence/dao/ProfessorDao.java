/**
 * 
 */
package spring.webapp.loginsystem.persistence.dao;

import spring.webapp.loginsystem.entity.Professor;

/**
 * @author Songhua Cui
 * 
 * 
 */
public interface ProfessorDao {

	/**
	 * @param email
	 * @return 
	 */
	Professor getProfessorbyEmail(String email) ;
	
	/**
	 * @param id
	 * @return 
	 */
	Professor getProfessorInfosbyId(long id);
}
