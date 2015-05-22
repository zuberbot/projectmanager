/**
 * MyProjectsDao
 */
package com.myprojects.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.web.dao.entity.Project;
import com.myprojects.web.dao.entity.ProjectDetails;
import com.myprojects.web.dao.entity.ProjectOrganization;
import com.myprojects.web.dao.entity.User;
import com.myprojects.web.utility.IProject;

/**
 * Provides the data access to (1) Project, (2) ProjectDetails and (3) ProjectOrganization entity beans.
 * 
 * @author Chuck
 *
 */
@Repository
@Transactional
@Component(IProject.MY_PROJECTS_DAO)
public class MyProjectsDao extends ProjectsDao {

	/**
	 * Get all of the projects for a particular owner.
	 * 
	 * @param ownerName
	 * @return
	 */
	public List<Project> getProjects(String ownerName) {
		SimpleExpression seProjectOwner = Restrictions.eq(IProject.PROJECT_OWNER, ownerName);
		SimpleExpression seActive = Restrictions.eq(IProject.ACTIVE, IProject.YES);

		Criteria cr = session().createCriteria(Project.class);
		cr.add(seProjectOwner);
		cr.add(seActive);
		
		@SuppressWarnings(IProject.UNCHECKED)
		List<Project> projects = cr.list();

		return projects;
	}

	/**
	 * Get the project's owner.
	 * 
	 * @param userName
	 * @return
	 */
	public String getProjectOwnerName(String userName) {
		SimpleExpression seUserName = Restrictions.eq(IProject.USER_NAME, userName);
		SimpleExpression seEnabled = Restrictions.eq(IProject.ENABLED, true);

		Criteria cr = session().createCriteria(User.class);
		cr.add(seUserName);
		cr.add(seEnabled);
		
		User user = (User) cr.uniqueResult();
		return user.getUserName();
	}

	/**
	 * Get the project based on the project id.
	 * 
	 * @param projectId
	 * @return
	 */
	public Project getProject(int projectId) {
		SimpleExpression seProjectId = Restrictions.eq(IProject.ID, projectId);
		SimpleExpression seActive = Restrictions.eq(IProject.ACTIVE, IProject.YES);
		
		Criteria cr = session().createCriteria(Project.class);
		cr.add(seProjectId);
		cr.add(seActive);

		Project project = (Project) cr.uniqueResult();
		return project;
	}


	/**
	 * Get a ProjectDetails based on the project id.
	 * 
	 * @param projectId
	 * @return
	 */
	public ProjectDetails getProjectDetails(int projectId) {
		SimpleExpression seProjectId = Restrictions.eq(IProject.PROJECT_ID, projectId);
		SimpleExpression seActive = Restrictions.eq(IProject.ACTIVE, IProject.YES);
		
		Criteria cr = session().createCriteria(ProjectDetails.class);
		cr.add(seProjectId);
		cr.add(seActive);

		ProjectDetails projectDetails = (ProjectDetails) cr.uniqueResult();
		return projectDetails;
	}

	/**
	 * Get a ProjectOrganization based on the project id.
	 * 
	 * @param projectId
	 * @return
	 */
	public ProjectOrganization getProjectOrganization(int projectId) {
		SimpleExpression seProjectId = Restrictions.eq(IProject.PROJECT_ID, projectId);
		SimpleExpression seActive = Restrictions.eq(IProject.ACTIVE, IProject.YES);
		
		Criteria cr = session().createCriteria(ProjectOrganization.class);
		cr.add(seProjectId);
		cr.add(seActive);

		ProjectOrganization projectOrganization = (ProjectOrganization) cr.uniqueResult();
		return projectOrganization;
	}
	/**
	 * Persist a Project.
	 * 
	 * @param project
	 */
	@Transactional
	public void saveProject(Project project) {
		// Write the new project to the database
		session().saveOrUpdate(project);
	}

	/**
	 * Persist a ProjectDetails.
	 * 
	 * @param projectDetails
	 */
	@Transactional
	public void saveProjectDetails(ProjectDetails projectDetails) {
		// Write the project details to the database
		session().saveOrUpdate(projectDetails);
	}

	/**
	 * Persist a ProjectOrganization.
	 * 
	 * @param projectOrganization
	 */
	@Transactional
	public void saveProjectOrganization(ProjectOrganization projectOrganization) {
		// Write the project organization to the database
		session().saveOrUpdate(projectOrganization);
	}

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public Project getProject(String projectId) {
		int pId = Integer.parseInt(projectId);
		return getProject(pId);
	}

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public ProjectDetails getProjectDetails(String projectId) {
		int pId = Integer.parseInt(projectId);
		return getProjectDetails(pId);
	}

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public ProjectOrganization getProjectOrganization(String projectId) {
		int pId = Integer.parseInt(projectId);
		return getProjectOrganization(pId);
	}
	
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public boolean deleteProject(int projectId) {
		// Instead of doing hard deletes, simply deactivate the record(s)
		ProjectDetails projectDetails = getProjectDetails(projectId);
		projectDetails.setActive(IProject.NO);
		session().saveOrUpdate(projectDetails);
		
		ProjectOrganization projectOrganization = getProjectOrganization(projectId);
		projectOrganization.setActive(IProject.NO);
		session().saveOrUpdate(projectOrganization);
		
		Project project = getProject(projectId);
		project.setActive(IProject.NO);
		session().saveOrUpdate(project);

		return true;
	}
}
