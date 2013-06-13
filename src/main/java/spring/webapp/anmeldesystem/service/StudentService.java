/**
 * 
 */
package spring.webapp.anmeldesystem.service;

import spring.webapp.anmeldesystem.entity.Student;

/**
 * @author Songhua Cui
 *
 */

public interface StudentService {
	/**
	 * @param email
	 * @return 
	 */
	Student getStudentInformationen(String email);
	
	/**
	 * @param studentId
	 * @return 
	 */
	Student getStudentById(long studentId);
	
	/**
	 * @param studentId
	 * @return 
	 */
	Student getStudentInfosById(long studentId);
}
