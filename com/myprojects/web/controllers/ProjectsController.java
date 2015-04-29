/**
 * ProjectsController
 */
package com.myprojects.web.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;

import com.myprojects.web.service.MyProjectsService;

/**
 * This is the parent class for all controllers, which holds methods and properties
 * common to all controllers.
 * 
 * @author Chuck
 * 
 */
@Controller
public class ProjectsController {

	/**
	 * 
	 * @param principal
	 * @param myProjectsService
	 * @return
	 */
	protected String getProjectOwnerName(Principal principal, MyProjectsService myProjectsService) {
		String ownerName = "";
		
		if (principal != null) {
			String userName = principal.getName();
			// Get the owner name (not user name)
			ownerName = myProjectsService.getProjectOwnerName(userName);
		}
		
		return ownerName;
	}
}
