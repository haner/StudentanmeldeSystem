/**
 * 
 */
package spring.webapp.anmeldesystem.entity;

/**
 * 
 *
 */
/**
 * Describe the different application roles that exist.
 * 
 * @author Songhua Cui
 * 
 */
public enum Role {

	/**
	 * Different Role of user.
	 * 
	 * 0 = Normal User; 1 = Student; 2 = Professor; 3 = Admin.
	 * 
	 * 
	 */
	USER("ROLE_USER", 0), STUDENT("ROLE_STUDENT", 1), PROFESSOR("ROLE_PROFESSOR", 2), ADMIN(
			"ROLE_ADMIN", 3);

	private final int order;
	private final String roleName;

	/**
	 * @param roleName
	 * @param order
	 */
	private Role(final String roleName, final int order) {
		this.roleName = roleName;
		this.order = order;
	}

	/**
	 * @return 
	 */
	public int order() {
		return order;
	}

	/**
	 * @return 
	 */
	public String roleName() {
		return roleName;
	}

}
