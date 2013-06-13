/**
 * 
 */
package spring.webapp.loginsystem.service.impl;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import spring.webapp.loginsystem.entity.Role;
import spring.webapp.loginsystem.service.CustomAuthenticationSuccessHandler;

/**
 * @author Songhua Cui
 *
 */
public class CustomAuthenticationSuccessHandlerImpl implements
		CustomAuthenticationSuccessHandler {

	private final static String DEFAULT_TARGET_URL = "/";
	private final static String TARGET_URL_STUDENT = "/studentHome";
	private final static String TARGET_URL_PROFESSOR = "/professorHome";
	private final static String TARGET_URL_ADMIN = "/adminHome";

	
	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	/**
	 * @param request
	 * @param response
	 * @param authentication
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains(Role.STUDENT.roleName())) {
            response.sendRedirect(request.getContextPath() + TARGET_URL_STUDENT);
        }else if(roles.contains(Role.PROFESSOR.roleName())){
            response.sendRedirect(request.getContextPath() + TARGET_URL_PROFESSOR);
        }else if(roles.contains(Role.ADMIN.roleName())){
            response.sendRedirect(request.getContextPath() + TARGET_URL_ADMIN);

        }else{
            response.sendRedirect(request.getContextPath() + DEFAULT_TARGET_URL);

        }
	}

}
