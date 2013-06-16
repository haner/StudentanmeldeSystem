/**
 * 
 */
package spring.webapp.anmeldesystem.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import spring.webapp.anmeldesystem.entity.Datei;
/**
 * @author Songhua Cui
 * 
 */
public interface DateiMapper {

	/**
	 * @param dateiId
	 * @return 
	 */
	Datei selectDateiByDateiId(long dateiId);
	
	/**
	 * @param name
	 * @param typ
	 * @return 
	 */
	Datei selectDateiByDateinameAndTyp(@Param("name") String name, @Param("typ") String typ);
	/**
	 * @param kursId
	 * @return 
	 */
	List<Datei> selectDateienByKursId(String kursId);
	

	/**
	 * @param datei
	 */
	void insertDatei(Datei datei);
	
	/**
	 * @param datei
	 */
	void updateDatei(Datei datei);
	/**
	 * 
	 * @param dateiId
	 */
	void deleteDatei(long dateiId);
	/**
	 * 
	 * @param dateiId
	 */
	void deleteDateiFromDateiKursProfessor(long dateiId);
}
