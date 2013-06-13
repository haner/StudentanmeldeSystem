/**
 * 
 */
package spring.webapp.anmeldesystem.persistence.dao;

import java.util.List;

import spring.webapp.anmeldesystem.entity.Fachbereich;

/**
 * @author Songhua Cui
 * 
 * 
 */
public interface FachbereichDao {

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
