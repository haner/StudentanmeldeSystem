package spring.webapp.loginsystem.entity;

public abstract class User {
	protected long id;
	protected String name;
	protected String email;
	protected String kennwort;
	protected String geschlecht;
	/**
	 * Access level of the user. 0 = Normal User; 1 = Student; 2 = Professor; 3
	 * = Admin.
	 */
	private Role role;

	/**
	 * @return 
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return 
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the kennwort
	 */
	public String getKennwort() {
		return kennwort;
	}

	/**
	 * @param kennwort the kennwort to set
	 */
	public void setKennwort(String kennwort) {
		this.kennwort = kennwort;
	}

	/**
	 * @return 
	 */
	public String getGeschlecht() {
		return geschlecht;
	}

	/**
	 * @param geschlecht
	 */
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	/**
	 * @return 
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 */
	public void setRole(Role role) {
		this.role = role;
	}
}