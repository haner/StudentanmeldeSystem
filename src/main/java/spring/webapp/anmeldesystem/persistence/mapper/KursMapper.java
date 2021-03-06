/**
 * 
 */
package spring.webapp.anmeldesystem.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import spring.webapp.anmeldesystem.entity.Kurs;

/**
 * @author Songhua Cui
 * 
 */
public interface KursMapper {

	/**
	 * 
	 * @param kursId
	 * @return {@link Kurs}
	 */
	Kurs selectKursByKursId(String kursId);

	/**
	 * @return 
	 */
	List<Kurs> selectKurse();

	/**
	 * @param kursId
	 * @return 
	 */
	Long selectProfessorFromKursProfessor(String kursId);

	/**
	 * @param kursId
	 * @param studentId
	 * @return 
	 */
	Long selectKursStudentByKursAndStudentId(@Param("kursId") String kursId,
			@Param("studentId") long studentId);

	/**
	 * @param kursId
	 * @return 
	 */
	ArrayList<Long> selectStudentIdsFromKursStudentByKursId(String kursId);
	
	/**
	 * @param fachbreichId
	 * @return 
	 */
	ArrayList<Kurs> selectKurseInFB(long fachbreichId);

	/**
	 * @param kurs
	 */
	void insertKurs(Kurs kurs);
	
	void insertKursInKURSFachbereich(@Param("kursId") String kursId,
			@Param("fbId") long fbId);

	/**
	 * 
	 * @param kursId
	 * @param studentId
	 */
	void insertStudentInKursStudent(@Param("kursId") String kursId,
			@Param("studentId") long studentId);

	/**
	 * 
	 * @param kursId
	 * @param professorId
	 */
	void insertProfessorInKursStudent(@Param("kursId") String kursId,
			@Param("professorId") long professorId);

	/**
	 * @param kurs
	 */
	void updateKurs(Kurs kurs);

	/**
	 * 
	 * @param kursId
	 */
	void deleteKurs(String kursId);
	
	/**
	 * 
	 * @param kursId
	 */
	void deleteKursProfessor(String kursId);
}
