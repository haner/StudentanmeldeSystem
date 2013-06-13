/**
 * 
 */
package spring.webapp.anmeldesystem.persistence.mapper;

import spring.webapp.anmeldesystem.entity.Admin;
import spring.webapp.anmeldesystem.entity.Professor;

/**
 * @author Songhua Cui
 *
 */
public interface AdminMapper {
	
	/**
	 * @param email
	 * @return {@link Admin}
	 */
	Admin selectAdminByEmail(String email);
	
	/**
	 * @param email
	 * @return 
	 */
	Professor selectProfessorMitKurseInfoByEmail(String email);
	
	/**
	 * @param id
	 * @return {@link Professor}
	 */
	Professor selectProfessorById(long id);
	/**
	 * @param professor
	 */
	void insertProfessor(Professor professor);
	
}
