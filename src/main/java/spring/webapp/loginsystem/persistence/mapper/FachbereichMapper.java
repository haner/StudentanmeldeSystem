/**
 * 
 */
package spring.webapp.loginsystem.persistence.mapper;

import java.util.ArrayList;

import spring.webapp.loginsystem.entity.Fachbereich;

/**
 * @author Songhua Cui
 *
 */
public interface FachbereichMapper {
	/**
	 * @return 
	 */
	ArrayList<Fachbereich> selectFachbereich();
	
	/**
	 * 
	 * @param fbId
	 * @return
	 */
	Fachbereich selectFachbereichById(long fbId);
	
	/**
	 * 
	 * @param fachbereich
	 */
	void insertFachbereich(Fachbereich fachbereich);
	
	/**
	 * 
	 * @param fachbereich
	 */
	void updateFachbereich(Fachbereich fachbereich);
	
	/**
	 * 
	 * @param fbId
	 */
	void deleteFachbereich(long fbId);

}
