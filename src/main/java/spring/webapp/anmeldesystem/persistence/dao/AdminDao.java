package spring.webapp.anmeldesystem.persistence.dao;

import spring.webapp.anmeldesystem.entity.Professor;
import spring.webapp.anmeldesystem.entity.Student;

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
