/**
 * 
 */
package spring.webapp.anmeldesystem.service;

import java.util.ArrayList;
import java.util.List;

import spring.webapp.anmeldesystem.entity.Kurs;

/**
 * @author Songhua Cui
 * 
 */

public interface KursService {
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
	ArrayList<Long> getStudentIdsFromKursStudent(String kursId);
	
	/**
	 * @param kursId
	 * @param studentId
	 */
	void addStudentIntoKursStudent(String kursId, long studentId);
	
	/**
	 * @param kurs
	 * @param professorId
	 */
	void addKurs(Kurs kurs, long professorId, long fbId);
	
	/**
	 * @param kursId
	 */
	void deleteKurs(String kursId);
	
	/**
	 * @param fachbreichId
	 * @return 
	 */
	ArrayList<Kurs> getKurseInFB(long fachbreichId);
}
