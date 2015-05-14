/**
 * GlobalExceptionController
 */
package com.myprojects.web.controllers.errorhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.myprojects.web.utility.IProject;

/**
 * @author Chuck
 *
 */
@ControllerAdvice
public class GlobalExceptionController {

	/**
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		// http://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
		e.printStackTrace();
		return IProject.ERROR;
	}
	
}
