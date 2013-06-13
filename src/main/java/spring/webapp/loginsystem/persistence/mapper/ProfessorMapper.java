/**
 * 
 */
package spring.webapp.loginsystem.persistence.mapper;

import spring.webapp.loginsystem.entity.Professor;

/**
 * @author Songhua Cui
 *
 */
public interface ProfessorMapper {
	
	/**
	 * @param email
	 * @return {@link Professor}
	 */
	Professor selectProfessorByEmail(String email);
	
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
	 * 
	 * @param professor
	 */
	void insertProfessor(Professor professor);
}
