/**
 * MyProjectsJSPUtility
 */
package com.myprojects.web.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Chuck
 * 
 */
public class MyProjectsJSPUtility {

	/**
	 * 
	 * @return
	 */
	public static String getLoggedOnUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication auth = securityContext.getAuthentication();
		String userId = auth.getName();
		return userId;
	}

}
