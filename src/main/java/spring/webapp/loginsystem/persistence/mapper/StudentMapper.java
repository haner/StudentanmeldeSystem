/**
 * 
 */
package spring.webapp.loginsystem.persistence.mapper;

import spring.webapp.loginsystem.entity.Professor;
import spring.webapp.loginsystem.entity.Student;

/**
 * @author Songhua Cui
 *
 */
public interface StudentMapper {
	
	/**
	 * @param email
	 * @return {@link Student}
	 */
	Student selectStudentByEmail(String email);
	/**
	 * @param id
	 * @return 
	 */
	Student selectStudentById(long id);
	/**
	 * @param email
	 * @return 
	 */
	Student selectStudentMitKurseInfoByEmail(String email);
	/**
	 * @param id
	 * @return {@link Student}
	 */
	Student selectStudentInfosById(long id);
	/**
	 * 
	 * @param student
	 */
	void insertStudent(Student student);
	
	/**
	 * @param professor
	 */
	void insertProfessor(Professor professor);
}
