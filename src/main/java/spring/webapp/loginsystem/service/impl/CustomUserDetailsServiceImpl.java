/**
 * 
 */
package spring.webapp.loginsystem.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.webapp.loginsystem.entity.Role;
import spring.webapp.loginsystem.entity.User;
import spring.webapp.loginsystem.persistence.dao.UserDao;
import spring.webapp.loginsystem.service.CustomUserDetailsService;

/**
 * @author Songhua Cui
 * 
 */
@Service
@Transactional(readOnly = true)
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CustomUserDetailsServiceImpl.class);

	@Resource
	private UserDao userDao;

	/**
	 * @param email
	 * @return @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		try {
			User user = userDao.searchUserByEmail(email);

			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;

			/*
			 * Collection<GrantedAuthority> auths = new
			 * ArrayList<GrantedAuthority>(); List<String> list =
			 * userDao.getAuthoritiesByEmail(email); for (int i = 0; i <
			 * list.size(); i++) { auths.add(new
			 * SimpleGrantedAuthority(list.get(i))); //
			 * System.out.println("loadUserByEmail : " + list.get(i)); }
			 */

			return new org.springframework.security.core.userdetails.User(
					user.getEmail(), user.getKennwort(), enabled,
					accountNonExpired, credentialsNonExpired, accountNonLocked,
					getAuthorities(user.getRole()));
		} catch (Exception e) {
			throw new UsernameNotFoundException("User mit der Email-Adresse"
					+ email + "existiert nicht.");
		}
	}

	/**
	 * Retrieves the correct ROLE type depending on the access level, where
	 * access level is an Integer. Basically, this interprets the access value
	 * whether it's for a regular user or admin.
	 * 
	 * @param role the {@link Role} of user.
	 * @return collection of granted authorities
	 */
	public Collection<GrantedAuthority> getAuthorities(Role role) {
		// Create a list of grants for this user
		/*
		 * List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(4);
		 */List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
		/*
		 * // All users are granted with ROLE_USER access // Therefore this user
		 * gets a ROLE_USER by default
		 * LOGGER.debug("Grant ROLE_USER to this user"); authList.add(new
		 * GrantedAuthorityImpl("ROLE_STUDENT"));
		 */

		/*
		 * // Check if this user has admin access // We interpret Integer(1) as
		 * an admin user if (access.compareTo(1) == 0) { // User has admin
		 * access LOGGER.debug("Grant ROLE_ADMIN to this user");
		 * authList.add(new GrantedAuthorityImpl("ROLE_ADMIN")); }
		 * 
		 * // Check if this user has student access // We interpret Integer(2)
		 * as a student if (access.compareTo(2) == 0) { // User has admin access
		 * LOGGER.debug("Grant ROLE_STUDENT to this user"); authList.add(new
		 * GrantedAuthorityImpl("ROLE_STUDENT")); }
		 * 
		 * // Check if this user has professor access // We interpret Integer(3)
		 * as a professor user if (access.compareTo(3) == 0) { // User has admin
		 * access LOGGER.debug("Grant ROLE_Professor to this user");
		 * authList.add(new GrantedAuthorityImpl("ROLE_Professor")); }
		 * 
		 * // Return list of granted authorities return authList;
		 */
	}

	/**
	 * Converts a numerical role to an equivalent list of roles
	 * 
	 * @param role the role of a user.
	 * @return list of roles as as a list of {@link String}
	 */
	public List<String> getRoles(Role role) {
		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_USER");

		if (Role.STUDENT.equals(role)) {
			roles.add(Role.STUDENT.roleName());

		} else if (Role.PROFESSOR.equals(role)) {
			roles.add(Role.PROFESSOR.roleName());
		} else {
			roles.add(Role.ADMIN.roleName());
		}

		return roles;
	}

	/**
	 * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
	 * 
	 * @param roles {@link String} of roles
	 * @return list of granted authorities
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(4);
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
	
}
