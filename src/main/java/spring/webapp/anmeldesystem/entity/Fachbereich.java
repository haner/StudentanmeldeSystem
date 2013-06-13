package spring.webapp.anmeldesystem.entity;

public class Fachbereich {
	private long fachId;
	private String fachName;
	private String beschreibung;
	private String dekan;
	private String prodekan;

	/**
	 * @param fachId
	 */
	public void setFachId(long fachId) {
		this.fachId = fachId;
	}

	/**
	 * @return 
	 */
	public long getFachId() {
		return fachId;
	}

	/**
	 * @param fachName
	 */
	public void setFachName(String fachName) {
		this.fachName = fachName;
	}

	/**
	 * @return 
	 */
	public String getFachName() {
		return fachName;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getDekan() {
		return dekan;
	}

	public void setDekan(String dekan) {
		this.dekan = dekan;
	}

	public String getProdekan() {
		return prodekan;
	}

	public void setProdekan(String prodekan) {
		this.prodekan = prodekan;
	}
}
