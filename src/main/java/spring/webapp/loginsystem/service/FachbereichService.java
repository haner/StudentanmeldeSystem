/**
 * 
 */
package spring.webapp.loginsystem.service;

import java.util.List;

import spring.webapp.loginsystem.entity.Fachbereich;

/**
 * @author Songhua Cui
 * 
 */

public interface FachbereichService {
	/**
	 * @param kursId
	 * @return 
	 */
	Fachbereich getFachbereichById(Long fbId);
	
	/**
	 * @return 
	 */
	List<Fachbereich> getFachbereich();

	/**
	 * @param fbId
	 */
	void deleteFachbereich(Long fbId);

	/**
	 * 
	 * @param fachbereich
	 */
	void addFachbereich(Fachbereich fachbereich);
}
