/**
 * MyProjectsService
 */
package com.myprojects.web.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.webflow.context.ExternalContext;
import org.springframework.webflow.execution.RequestContext;

import com.myprojects.web.dao.MyProjectsDao;
import com.myprojects.web.dao.ProjectSearchDao;
import com.myprojects.web.dao.entity.Project;
import com.myprojects.web.dao.entity.ProjectDetails;
import com.myprojects.web.dao.entity.ProjectOrganization;

import com.myprojects.web.utility.MyProjectsUtility;
import com.myprojects.web.utility.IProject;

/**
 * Provides the service for MyProjectsDao, which handles Project, ProjectDetails and ProjectOrganization.
 * 
 * @author Chuck
 *
 */
@Component(IProject.MY_PROJECTS_SERVICE)
public class MyProjectsService {

	@Autowired
	private MyProjectsDao myProjectsDao;
	
	@Autowired
	private ProjectSearchDao projectSearchDao;

	/**
	 * Save a Project.
	 * 
	 * @param project
	 */
	public void saveProject(Project project) {
		// Set the created date
		String dateCreated = MyProjectsUtility.getCurrentMySQLDate();
		project.setCreatedDate(dateCreated);
		
		// MySQL defaults are not working
		project.setUpdatedLastDate(dateCreated);
		project.setActive(IProject.YES);

		// Save the project
		myProjectsDao.saveProject(project);
	}
	
	/**
	 * Save a ProjectDetails.
	 * 
	 * @param projectDetails
	 * @param project
	 */
	public void saveProjectDetails(ProjectDetails projectDetails, Project project) {
		// Set the created date
		String dateCreated = MyProjectsUtility.getCurrentMySQLDate();
		projectDetails.setCreatedDate(dateCreated);
		
		// MySQL defaults are not working
		projectDetails.setUpdatedLastDate(dateCreated);
		projectDetails.setActive(IProject.YES);

		if (project != null) {
			projectDetails.setProjectId(project.getId());
		} else {
			// This ProjectDetails is not attached to a project
			projectDetails.setProjectId(-1);
		}
		
		// Save project details
		myProjectsDao.saveProjectDetails(projectDetails);
	}
	
	/**
	 * Save a ProjectOrganization.
	 * 
	 * @param projectOrganization
	 * @param project
	 */
	public void saveProjectOrganization(ProjectOrganization projectOrganization, Project project) {		
		// Set the created date
		String dateCreated = MyProjectsUtility.getCurrentMySQLDate();
		projectOrganization.setCreatedDate(dateCreated);

		// MySQL defaults are not working
		projectOrganization.setUpdatedLastDate(dateCreated);
		projectOrganization.setActive(IProject.YES);

		if (project != null) {
			projectOrganization.setProjectId(project.getId());
		} else {
			// This ProjectDetails is not attached to a project
			projectOrganization.setProjectId(-1);
		}
		
		// Save project organization
		myProjectsDao.saveProjectOrganization(projectOrganization);
	}
	
	/**
	 * Get a Project based on the project id.
	 * 
	 * @param projectId
	 * @return
	 */
	public Project getProject(int projectId) {
		return myProjectsDao.getProject(projectId);
	}
	
	/**
	 * Get a ProjectDetails based on the project id.
	 * 
	 * @param projectId
	 * @return
	 */
	public ProjectDetails getProjectDetails(int projectId) {
		return myProjectsDao.getProjectDetails(projectId);
	}
	
	/**
	 * Get a ProjectOrganization based on the project id.
	 * 
	 * @param projectId
	 * @return
	 */
	public ProjectOrganization getProjectOrganization(int projectId) {
		return myProjectsDao.getProjectOrganization(projectId);
	}
	
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public Project getProject(String projectId) {
		return myProjectsDao.getProject(projectId);
	}
	
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public ProjectDetails getProjectDetails(String projectId) {
		return myProjectsDao.getProjectDetails(projectId);
	}

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public ProjectOrganization getProjectOrganization(String projectId) {
		return myProjectsDao.getProjectOrganization(projectId);
	}

	/**
	 * Get a Project from the request.
	 * 
	 * @param requestContext
	 * @return
	 */
	public Project getProject(RequestContext requestContext) {
		// Call the project object retrieval method
		Project project = (Project) getProjectObject(requestContext, IProject.PROJECT);
		
		if (project != null) {
			// Editing an existing project
			return project;
		}
	    
		// For a brand new project
	    return new Project();
	}
	
	/**
	 * Get a ProjectDetails from the request.
	 * 
	 * @param requestContext
	 * @return
	 */
	public ProjectDetails getProjectDetails(RequestContext requestContext) {
		// Call the project object retrieval method
		ProjectDetails projectDetails = (ProjectDetails) getProjectObject(requestContext, IProject.PROJECT_DETAILS);
		
		if (projectDetails != null) {
			// Editing an existing project
			return projectDetails;
		}
	    
		// For a brand new project
	    return new ProjectDetails();		
	}
	
	/**
	 * Get a ProjectOrganization from the request.
	 * 
	 * @param requestContext
	 * @return
	 */
	public ProjectOrganization getProjectOrganization(RequestContext requestContext) {
		// Call the project object retrieval method
		ProjectOrganization projectOrganization = (ProjectOrganization) getProjectObject(requestContext, IProject.PROJECT_ORGANIZATION);
		
		if (projectOrganization != null) {
			// Editing an existing project
			return projectOrganization;
		}
	    
		// For a brand new project
	    return new ProjectOrganization();
	}
	
	/**
	 * Destination end of flash attributes.
	 * 
	 * @param requestContext
	 * @param parameter
	 * @return
	 */
	private Object getProjectObject(RequestContext requestContext, String parameter) {
		// Get the external context from the request context
		ExternalContext externalContext = requestContext.getExternalContext();
		// So as to get a handle to the request object
		HttpServletRequest httpRequest = (HttpServletRequest) externalContext.getNativeRequest();
		// Get the flash attributes
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(httpRequest);
		
		if (inputFlashMap != null) {
			// Get the project object from it
			Object projectObject = inputFlashMap.get(parameter);
		    
		    if (projectObject != null) {
		    	return projectObject;
		    }
		}		
	    
	    return null;
	}
	
	/**
	 * Get the Project's owner from the user id.
	 * 
	 * @param userName
	 * @return
	 */
	public String getProjectOwnerName(String userName) {
		return myProjectsDao.getProjectOwnerName(userName);
	}
	
	/**
	 * Get project search results.
	 * 
	 * @param searchString
	 * @param ownerName
	 * @return
	 */
	public String getProjectSearchResult(String searchString, String ownerName) {
		// Invoke data layer get projects, owner name is to record who made the search
		List<Project> projectSearchResults = projectSearchDao.getProjects(searchString, ownerName);
		
		StringBuffer sb = new StringBuffer();
		sb.append("{\"projects\": {");
		
		// Need a JSON converter class (JSON -> String)
		for (Project p : projectSearchResults) {
			int projectId = p.getId();
			String projectOwner = p.getProjectOwner();
			String projectName = p.getProjectName();
			String projectShortDesc = p.getProjectShortDescription();
			String projectCreationDate = p.getCreatedDate();
			
			// JSON details 
			sb.append("\"project" + projectId + "\": {");
			sb.append("\"Project Name\": \"" + projectName + "\",");
			sb.append("\"Project Owner\": \"" + projectOwner + "\",");
			sb.append("\"Project Summary\": \"" + projectShortDesc + "\",");
			sb.append("\"Project Creation Date\": \"" + projectCreationDate + "\"");
			sb.append("},");
			
//			{"projects": {
//			    "project0": {
//	        		"Project Name": "Sample project",
//	        		"Project Owner": "chuck",
//			        "Project Summary": "Sample short description",
//	        		"Project Creation Date": "2014-11-29 09:21:40"
//			    },
//			    "project1": { 
//	        		"Project Name": "Sample project",
//    				"Project Owner": "tom",
//	        		"Project Summary": "Sample short description",
//    				"Project Creation Date": "2014-11-30 14:25:42"
//			    },
//			}}
		}
		
		// Remove that extra comma
		String json = sb.substring(0, sb.length() - 1);
		json += "}}";
		
		return json;
	}

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public boolean deleteProject(int projectId) {
		return myProjectsDao.deleteProject(projectId);
	}

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public boolean deleteProject(String projectId) {
		int pId = Integer.parseInt(projectId);
		return myProjectsDao.deleteProject(pId);
	}
}
