package spring.webapp.anmeldesystem.service;

import spring.webapp.anmeldesystem.entity.Professor;
import spring.webapp.anmeldesystem.entity.Student;

/**
 * @author Songhua Cui
 */
public interface AdminService {
	/**
	 * @param Student
	 */
	void addStudent(Student Student);

	/**
	 * @param Professor
	 */
	void addProfessor(Professor Professor);

	/**
	 * @param Professor
	 */
	void updateProfessor(Professor Professor);

	/**
	 * @param Student
	 */
	void updateStudent(Student Student);

	/**
	 * @param Student
	 */
	void resetStudent(Student Student);

	/**
	 * @param Professor
	 */
	void resetProfessor(Professor Professor);
}