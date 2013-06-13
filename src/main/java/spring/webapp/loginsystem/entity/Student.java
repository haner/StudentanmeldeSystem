/**
 * 
 */
package spring.webapp.loginsystem.entity;

import java.util.List;

/**
 * Code wurde automatisch durch Magicdraw generiert.
 * @author Songhua Cui
 */
public class Student extends User {
	private int semesterNummber;
	private int fachrichtung;
	private List<Kurs> kurse;
	private List<Fachbereich> fachbereich;

	/**
	 * @return 
	 */
	public int getSemesterNummber() {
		return semesterNummber;
	}
	/**
	 * @param semesterNummber
	 */
	public void setSemesterNummber(int semesterNummber) {
		this.semesterNummber = semesterNummber;
	}
	/**
	 * @return 
	 */
	public int getFachrichtung() {
		return fachrichtung;
	}
	/**
	 * @param fachrichtung
	 */
	public void setFachrichtung(int fachrichtung) {
		this.fachrichtung = fachrichtung;
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
