/**
 * 
 */
package spring.webapp.loginsystem.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import spring.webapp.loginsystem.entity.Kurs;

/**
 * @author Songhua Cui
 * 
 * 
 */
public interface KursDao {

	/**
	 * @param kursId
	 * @return 
	 */
	Kurs getKursById(String kursId);
	
	/**
	 * @return 
	 */
	List<Kurs> getKurse();
	
	/**
	 * @param kursId
	 * @return 
	 */
	ArrayList<Long> getStudentIdFromKursStudent(String kursId);
	
	/**
	 * @param fachbreichId
	 * @return 
	 */
	ArrayList<Kurs> getKurseInFB(long fachbreichId);

	/**
	 * @param kursId
	 */
	void deleteKurs(String kursId);

	/**
	 * @param kurs
	 * @param professorId
	 */
	void addKurs(Kurs kurs, long professorId);

	/**
	 * @param kursId
	 * @param studentId
	 */
	void addStudentIntoKursStudent(String kursId, long studentId);
}
