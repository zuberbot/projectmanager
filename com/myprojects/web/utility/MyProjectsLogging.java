/**
 * MyProjectsLogging
 */
package com.myprojects.web.utility;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author Chuck
 *
 */
@Aspect
@Component
@EnableAspectJAutoProxy
public class MyProjectsLogging {

	/**
	 * 
	 */
	@Pointcut(IProject.POINTCUT_SHOW_HOME)
	private void pointcutShowHome() {
		// Do nothing
	}
	
	/**
	 * 
	 */
	@Before(IProject.POINTCUT_SHOW_HOME_METHOD)
	public void beforePointcutShowHome() {
		//Logger logger = Logger.getLogger(com.myprojects.web.controllers.HomeController.class);
		//logger.debug("> Showing home page!");
	}

	/**
	 * 
	 */
	@Pointcut(IProject.POINTCUT_VIEW_MY_PROJECTS)
	private void pointcutViewMyProjects() {
		// Do nothing
	}
	
	/**
	 * 
	 */
	@Before(IProject.POINTCUT_VIEW_MY_PROJECTS_METHOD)
	public void beforePointcutViewMyProjects() {
		Logger logger = Logger.getLogger(com.myprojects.web.controllers.HomeController.class);
		logger.info(IProject.VIEWING_USERS_PROJECTS);
	}

	/**
	 * 
	 */
	@Pointcut(IProject.POINTCUT_PROJECT_SEARCH_RESULTS_SERVICE)
	private void pointcutProjectSearchResultsService() {
		// Do nothing
	}
	
	/**
	 * 
	 */
	@After(IProject.POINTCUT_PROJECT_SEARCH_RESULTS_SERVICE_METHOD)
	public void afterPointcutProjectSearchResultsService() {
		Logger logger = Logger.getLogger(com.myprojects.web.service.MyProjectsService.class);
		logger.info(IProject.VIEWING_SEARCH_RESULTS);
	}
}
