/**
 * 
 */
package spring.webapp.loginsystem.service;

import spring.webapp.loginsystem.entity.Professor;

/**
 * @author Songhua Cui
 *
 */

public interface ProfessorService {
	/**
	 * @param email
	 * @return 
	 */
	Professor getProfessorInformationen(String email);
}
