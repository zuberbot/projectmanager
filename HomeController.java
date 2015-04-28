/**
 * HomeController
 */
package com.myprojects.web.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myprojects.web.dao.entity.UserMessage;
import com.myprojects.web.service.UserMessagesService;
import com.myprojects.web.utility.IProject;

/**
 * @author Chuck
 *
 */
@Controller
public class HomeController extends ProjectsController {

	@Autowired
	private UserMessagesService userMessagesService;

	/**
	 * 
	 * @param model
	 * @param principal
	 * @return
	 */
	@RequestMapping(IProject.ROOT)
	public String showHome(Model model, Principal principal) {
		// Retrieve messages
		
		if (principal != null) {
			String userId = principal.getName();
			List<UserMessage> userMessages = userMessagesService.getUserMessages(userId);
			
			// Send to JSP
			model.addAttribute(IProject.USER_MESSAGES, userMessages);
		}
		
		return IProject.HOME;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(IProject.HELP_PATH)
	public String showHelp() {
		return IProject.HELP;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(IProject.TEST_DB_CONNECTIVITY)
	public String showDBTestConnection() {
		return IProject.TEST_DB;
	}
}
