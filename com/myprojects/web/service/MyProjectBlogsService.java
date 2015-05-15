/**
 * MyProjectBlogsService
 */
package com.myprojects.web.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myprojects.web.dao.MyProjectBlogsDao;
import com.myprojects.web.dao.MyProjectsDao;
import com.myprojects.web.dao.UsersDao;
import com.myprojects.web.dao.entity.Project;
import com.myprojects.web.dao.entity.ProjectBlog;
import com.myprojects.web.dao.entity.User;

import com.myprojects.web.utility.MyProjectsUtility;
import com.myprojects.web.utility.IProject;

/**
 * @author Chuck
 *
 */
@Component(IProject.MY_PROJECT_BLOG_SERVICE)
public class MyProjectBlogsService {

	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private MyProjectsDao myProjectsDao;

	@Autowired
	private MyProjectBlogsDao myProjectBlogsDao;
	
	private int postedBlogProjectId;
	
	/**
	 * 
	 */
	public MyProjectBlogsService() {
		// Default to no open BLOG projects
		postedBlogProjectId = -1;
	}

	/**
	 * 
	 * @return
	 */
	public ProjectBlog newProjectBlog() {
		// Ensure each BLOG view in JSP is empty
		return new ProjectBlog();
	}
	
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public List<ProjectBlog> getProjectBlogs(String projectId) {
		int pId = Integer.parseInt(projectId);
		return myProjectBlogsDao.getProjectBlogs(pId);
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public List<ProjectBlog> getCurrentProjectBlogs(String userName) {
		return myProjectBlogsDao.getProjectBlogs(userName);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPostedBlogProjectId() {
		return postedBlogProjectId;
	}

	/**
	 * 
	 * @param postedBlogProjectId
	 */
	public void setPostedBlogProjectId(int postedBlogProjectId) {
		this.postedBlogProjectId = postedBlogProjectId;
	}

	/**
	 * 
	 * @param projectBlog
	 */
	public void postBlog(@Valid ProjectBlog projectBlog) {
		// Form validation handled client-side
		// Issue with not identifying the correct project in response 

		// Get the project id to send back to JSP to keep open
		postedBlogProjectId = projectBlog.getProjectId();
	
		// Include any other ProjectBlog parameters
		String dateCreated = MyProjectsUtility.getCurrentMySQLDate();
		projectBlog.setCreatedDate(dateCreated);
		projectBlog.setUpdatedLastDate(dateCreated);
		
		// Write the project BLOG to the DB
		myProjectBlogsDao.save(projectBlog);
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public User getUser(String userName) {
		return usersDao.getUser(userName);
	}
	
	/**
	 * 
	 * @param ownerName
	 * @return
	 */
	public List<Project> getCurrentProjects(String ownerName) {
		return myProjectsDao.getProjects(ownerName);
	}

	/**
	 * 
	 * @param userName
	 * @return
	 */
	public String getProjectOwnerName(String userName) {
		return myProjectsDao.getProjectOwnerName(userName);
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	protected int[] getProjectIds(String userName) {
		List<Project> projects = getCurrentProjects(userName);
		int[] projectIds = new int[projects.size()];
		
		int i = 0;
		for (Project p : projects) {
			projectIds[i] = p.getId();
			i++;
		}
		
		return projectIds;
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public String getProjectsJQuery(String userName) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("<script type=\"text/javascript\">\n");		
		sb.append("$(document).ready(function() {\n");
		
		List<Project> projects = getCurrentProjects(userName);
		int[] projectIds = getProjectIds(userName);
		String blogId = "";

		// Start with all BLOGS hidden
		for (int pId : projectIds) {
			blogId = "blog" + pId;
			
			if (postedBlogProjectId == pId) {
				sb.append("$(\"#" + blogId + "\").show(\"slow\");\n");
			} else {				
				sb.append("$(\"#" + blogId + "\").hide();\n");
			}
		} // End for
		
		// Set up the JQuery to allow click open the BLOGS
		for (Project p : projects) {
			int projectId = p.getId();
			sb.append("$(\"#" + projectId + "\").click(function() {\n");
			
			// When user clicks a new project hide all errors
			sb.append("$(\".error\").hide();");
			
			for (int pId : projectIds) {
				blogId = "blog" + pId;
				
				if (pId == projectId) {
					sb.append("$(\"#" + blogId + "\").show(\"slow\");\n");
				} else {
					sb.append("$(\"#" + blogId + "\").hide();\n");
				}
			}
			
			sb.append("});\n");
		}
		
		sb.append("});\n");
		sb.append("</script>");
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public ProjectBlog getProjectBlog(String projectId) {
		return myProjectBlogsDao.getProjectBlog(projectId);
	}
	
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public boolean deleteProjectBlog(String projectId) {
		int pId = Integer.parseInt(projectId);
		return myProjectBlogsDao.deleteProjectBlog(pId);
	}
}
