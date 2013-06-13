package spring.webapp.loginsystem.persistence.mapper;

import org.apache.ibatis.annotations.Param;

import spring.webapp.loginsystem.entity.DateiKursProfessor;

public interface DateiKursProfessorMapper {

	/**
	 * @param dateiId
	 * @return 
	 */
	DateiKursProfessor selectByDateiId(long dateiId);
	
	/**
	 * @param kursId
	 * @return 
	 */
	DateiKursProfessor selectByKursId(String kursId);
	
	/**
	 * @param dateiId
	 * @param kursId
	 * @param professorId
	 * @return 
	 */
	DateiKursProfessor selectByDateiKursProfessor(@Param("dateiId") long dateiId,
			@Param("kursId") String kursId,
			@Param("professorId") long professorId);

	/**
	 * 
	 * @param dateiId
	 * @param kursId
	 * @param professorId
	 */
	void insertDateiKursProfessor(@Param("dateiId") long dateiId,
			@Param("kursId") String kursId,
			@Param("professorId") long professorId);

	/**
	 * 
	 * @param dateiId
	 * @param kursId
	 */
	void updateDateiKursProfessor(@Param("dateiId") long dateiId,
			@Param("kursId") String kursId);

	/**
	 * 
	 * @param dateiId
	 * @param kursId
	 */
	void deleteDateiKursProfessor(@Param("dateiId") long dateiId,
			@Param("kursId") String kursId);
}
