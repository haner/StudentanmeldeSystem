/**
 * 
 */
package spring.webapp.anmeldesystem.service;

import spring.webapp.anmeldesystem.entity.Professor;

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
