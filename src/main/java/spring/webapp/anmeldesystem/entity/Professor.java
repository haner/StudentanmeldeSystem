package spring.webapp.anmeldesystem.entity;

import java.util.List;

/**
 * Code wurde automatisch durch Magicdraw generiert.
 * @author Songhua Cui
 */
public class Professor extends User {
	private List<Kurs> kurse;
	private String name;
	private List<Fachbereich> fachbereich;
	/**
	 * @param name
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @param kurse
	 */
	public void setKurse(List<Kurs> kurse) {
		this.kurse = kurse;
	}

	/**
	 * @return 
	 */
	public List<Kurs> getKurse() {
		return kurse;
	}

	/**
	 * @param fachbereich
	 */
	public void setFachbereich(List<Fachbereich> fachbereich) {
		this.fachbereich = fachbereich;
	}

	/**
	 * @return 
	 */
	public List<Fachbereich> getFachbereich() {
		return fachbereich;
	}
}
