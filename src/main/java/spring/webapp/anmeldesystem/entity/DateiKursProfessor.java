/**
 * 
 */
package spring.webapp.anmeldesystem.entity;

/**
 * @author Songhua Cui
 * 
 */
public class DateiKursProfessor {
	private long dateiId;
	private String kursId;
	private long professorId;

	/**
	 * @return 
	 */
	public long getDateiId() {
		return dateiId;
	}

	/**
	 * @param dateiId
	 */
	public void setDateiId(long dateiId) {
		this.dateiId = dateiId;
	}

	/**
	 * @return 
	 */
	public String getKursId() {
		return kursId;
	}

	/**
	 * @param kursId
	 */
	public void setKursId(String kursId) {
		this.kursId = kursId;
	}

	/**
	 * @return 
	 */
	public long getProfessorId() {
		return professorId;
	}

	/**
	 * @param professorId
	 */
	public void setProfessorId(long professorId) {
		this.professorId = professorId;
	}

}
