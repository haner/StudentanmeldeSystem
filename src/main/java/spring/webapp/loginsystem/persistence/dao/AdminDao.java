package spring.webapp.loginsystem.persistence.dao;

import spring.webapp.loginsystem.entity.Professor;
import spring.webapp.loginsystem.entity.Student;

/**
 * @autor Songhua Cui
 */
public interface AdminDao {

	/**
	 * @param student
	 */
	void addStudent(Student student);

	/**
	 * @param student
	 */
	void updateStudent(Student student);

	/**
	 * @param student
	 */
	void resetStudent(Student student);

	/**
	 * @param professor
	 */
	void addProfessor(Professor professor);

	/**
	 * @param professor
	 */
	void updateProfessor(Professor professor);

	/**
	 * @param professor
	 */
	void resetProfessor(Professor professor);
}
