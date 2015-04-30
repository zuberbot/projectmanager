/**
 * MyProjectsController
 */
package com.myprojects.web.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myprojects.web.dao.entity.UserMessage;
import com.myprojects.web.dao.entity.Project;
import com.myprojects.web.dao.entity.ProjectDetails;
import com.myprojects.web.dao.entity.ProjectOrganization;
import com.myprojects.web.dao.entity.ProjectSearch;
import com.myprojects.web.service.MyProjectBlogsService;
import com.myprojects.web.service.MyProjectsService;
import com.myprojects.web.service.UserMessagesService;
import com.myprojects.web.utility.IProject;

/**
 * @author Chuck
 * 
 */
@Controller
public class MyProjectsController extends ProjectsController {

	@Autowired
	private MyProjectsService myProjectsService;

	@Autowired
	private MyProjectBlogsService myProjectBlogsService;
	
	@Autowired
	private UserMessagesService userMessagesService;

	/**
	 * Opens up the create project HTML form.
	 * 
	 * @param model
	 * @param principal
	 * @return
	 */
	@RequestMapping(IProject.CREATE_PROJECT_PATH)
	public String createProject(RedirectAttributes model, Principal principal) {
		// Set up a new Project
		Project project = new Project();
		// Future enhancement to use in web flow
		model.addFlashAttribute(IProject.PROJECT, project); //model.addAttribute

		// Link new project with owner (user id)
		String ownerName = getProjectOwnerName(principal, myProjectsService);
		//model.addFlashAttribute("owner", ownerName); //model.addAttribute

		// You can send an entire object via a redirect flash attribute here
		// Notice the RedirectAttributes sub-interface of Model parameter above
		//model.addFlashAttribute("principal", principal);

		//return "createproject"; // to JSP

		// NOTE: Redirect used as a path to redirect browser, instead of looking up a view.
		// When a controller method results in a redirect, the original request ends and 
		// a new HTTP GET request begins. Any model data carried in the original request 
		// dies with the request.

		// Here is the entry point into the create project web flow (see createproject-flow.xml)
		return "redirect:/createprojectflow?owner=" + ownerName;
	}

	/**
	 * Opens up the create project HTML form with project info filled in.
	 * 
	 * @param model
	 * @param projectId
	 * @return
	 */
	@RequestMapping(IProject.EDIT_PROJECT_PATH)
	public String editProject(RedirectAttributes model, @RequestParam(IProject.PROJECT_ID) int projectId) {
		// Get the project
		Project project = myProjectsService.getProject(projectId);		
		ProjectDetails projectDetails = myProjectsService.getProjectDetails(projectId);
		ProjectOrganization projectOrganization = myProjectsService.getProjectOrganization(projectId);
		
		// Add project to request model
		model.addFlashAttribute(IProject.PROJECT, project);
		model.addFlashAttribute(IProject.PROJECT_DETAILS, projectDetails);
		model.addFlashAttribute(IProject.PROJECT_ORGANIZATION, projectOrganization);

		// Get the project owner name
		String ownerName = project.getProjectOwner();
		
		// Redirect to the web flow
		return "redirect:/createprojectflow?owner=" + ownerName;
	}

	/**
	 * Opens up the create project HTML form.
	 * 
	 * @return
	 */
	@RequestMapping(IProject.VIEW_PROJECT_PATH)
	public String viewMyProjects() {
		// Add any preliminary info/steps here
		return "redirect:/myprojectsflow";
	}

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	@RequestMapping(value=IProject.DELETE_PROJECT_PATH)
	public String deleteProject(@RequestParam(value=IProject.PROJECT_ID, required=false) String projectId) {
		// Delete the project
		myProjectBlogsService.deleteProjectBlog(projectId);
		myProjectsService.deleteProject(projectId);
		return IProject.PROJECT_DELETED; // to tile
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(IProject.SEARCH_PROJECTS_PATH)
	public String searchProjects(Model model) {
		// May only want to add search-able projects here to the return model
		// Where you add allow searching in your project (another field in project)
		ProjectSearch projectSearch = new ProjectSearch();
		model.addAttribute(IProject.PROJECT_SEARCH, projectSearch);		
		return IProject.SEARCH_PROJECTS; // to tile
	}	

	/**
	 * 
	 * @param principal
	 * @param data
	 * @return
	 */
	@RequestMapping(value=IProject.DO_SEARCH_PROJECTS_PATH, method=RequestMethod.POST, produces=IProject.APPLICATION_JSON)
	public @ResponseBody Map<String, Object> doSearchProjects(Principal principal, 
			@RequestBody Map<String, Object> data) {
		
		String text = (String) data.get(IProject.SEARCH_STRING);
		// Remove quotes from string
		text = text.replace(IProject.DOUBLE_QUOTE, IProject.EMPTY_STRING);
		
		String ownerName = getProjectOwnerName(principal, myProjectsService);
		
		// Here's where we make the call to the DB
		String projectSearchResults = myProjectsService.getProjectSearchResult(text, ownerName);
		
		Map<String, Object> rVal = new HashMap<String, Object>();
		rVal.put(IProject.SUCCESS, true);
		rVal.put(IProject.SEARCH_RESULTS, projectSearchResults);

		return rVal;
	}

	/**
	 * 
	 * @param model
	 * @param principal
	 * @param receiver
	 * @param subject
	 * @return
	 */
	@RequestMapping(IProject.SEND_MESSAGE_REPLY_PATH)
	public String sendUserMessageReply(Model model, Principal principal, 
			@RequestParam(value=IProject.RECEIVER, required=true) String receiver, 
			@RequestParam(value=IProject.SUBJECT, required=true) String subject) {
		
		// Create new UserMessage bean and pass to JSP
		UserMessage userMessage = new UserMessage();
		model.addAttribute(IProject.USER_MESSAGE, userMessage);

		// Send logged on user id
		model.addAttribute(IProject.LOGGED_ON_USER, principal.getName());
		
		// Send reply subject
		model.addAttribute(IProject.REPLY_SUBJECT, subject);
		
		// Receiver user id of the project
		model.addAttribute(IProject.NAME_OF_USER, receiver);
		
		return IProject.SEND_MESSAGE; // to tile
	}	

	/**
	 * 
	 * @param model
	 * @param principal
	 * @param projectId
	 * @return
	 */
	@RequestMapping(IProject.SEND_MESSAGE_PATH)
	public String sendUserMessage(Model model, Principal principal, 
			@RequestParam(value=IProject.PROJECT_ID_LOWER, required=true) String projectId) {
		
		// Create new UserMessage bean and pass to JSP
		UserMessage userMessage = new UserMessage();
		model.addAttribute(IProject.USER_MESSAGE, userMessage);

		// Send logged on user id
		model.addAttribute(IProject.LOGGED_ON_USER, principal.getName());
		
		// Receiver user id of the project
		String nameOfUser = userMessagesService.getUserId(projectId);
		model.addAttribute(IProject.NAME_OF_USER, nameOfUser);
		
		return IProject.SEND_MESSAGE; // to tile
	}	

	/**
	 * 
	 * @param userMessage
	 * @return
	 */
	@RequestMapping(value=IProject.DO_SEND_MESSAGE, method=RequestMethod.POST)
	public String doSendUserMessage(@Valid UserMessage userMessage) {
		userMessagesService.sendUserMessage(userMessage);
		return IProject.MESSAGE_SENT; // to tile
	}
}
