/**
 * ProjectSearchDao
 */
package com.myprojects.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.web.dao.entity.Project;
import com.myprojects.web.dao.entity.ProjectSearch;
import com.myprojects.web.utility.IProject;
import com.myprojects.web.utility.MyProjectsUtility;

/**
 * @author Chuck
 *
 */
@Repository
@Transactional
@Component(IProject.PROJECT_SEARCH_DAO)
public class ProjectSearchDao extends ProjectsDao {

	/**
	 * 
	 * @param searchString
	 * @return
	 */
	public List<Project> getProjects(String searchString) {
		return getProjects(searchString, null);
	}

	/**
	 * 
	 * @param searchString
	 * @param ownerName
	 * @return
	 */
	public List<Project> getProjects(String searchString, String ownerName) {
		// Insert search string for recording purposes
		ProjectSearch projectSearch = new ProjectSearch();
		projectSearch.setUserName(ownerName);
		projectSearch.setSearchString(searchString);
		String dateCreated = MyProjectsUtility.getCurrentMySQLDate();
		projectSearch.setCreatedDate(dateCreated);
		session().save(projectSearch);

		// Retrieve project search results
		Criteria cr = session().createCriteria(Project.class);
		Criterion rest1 = Restrictions.like(IProject.PROJECT_NAME, IProject.HQL_WILDCARD + searchString + IProject.HQL_WILDCARD);
		Criterion rest2 = Restrictions.like(IProject.PROJECT_SUMMARY, IProject.HQL_WILDCARD + searchString + IProject.HQL_WILDCARD);
		cr.add(Restrictions.eq(IProject.ACTIVE, IProject.YES));
		cr.add(Restrictions.or(rest1, rest2));
		
		// Return back no more than ten until you get pagination working
		cr.setMaxResults(10);

		@SuppressWarnings(IProject.UNCHECKED)
		List<Project> projects = cr.list();

		return projects;
	}
}
