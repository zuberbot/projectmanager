/**
 * MyProjectBlogsDao
 */
package com.myprojects.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.web.dao.entity.ProjectBlog;

import com.myprojects.web.utility.IProject;

/**
 * @author Chuck
 *
 */
@Repository
@Transactional
@Component(IProject.MY_PROJECTS_BLOG_DAO)
public class MyProjectBlogsDao extends ProjectsDao {

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public List<ProjectBlog> getProjectBlogs(int projectId) {
		Criteria cr = session().createCriteria(ProjectBlog.class);
		cr.add(Restrictions.like(IProject.PROJECT_ID, projectId));
		cr.add(Restrictions.eq(IProject.ACTIVE, IProject.YES));
		cr.addOrder(Order.desc(IProject.CREATED_DATE));
		@SuppressWarnings(IProject.UNCHECKED)
		List<ProjectBlog> projectBlogs = cr.list();
		return projectBlogs;
	}

	/**
	 * 
	 * @param userName
	 * @return
	 */
	public List<ProjectBlog> getProjectBlogs(String userName) {
		Query query = session().createQuery(IProject.SELECT_ID_QUERY);
		query.setString(IProject.USER_NAME, userName);
		query.setString(IProject.ACTIVE, IProject.YES);
		@SuppressWarnings(IProject.UNCHECKED)
		List<Integer> projectIds = query.list();
		
		List<ProjectBlog> projectBlogs = new ArrayList<>();

		for (Integer id : projectIds) {
			List<ProjectBlog> pBs = getProjectBlogs(id);
			
			for (ProjectBlog pB : pBs) {
				projectBlogs.add(pB);
			}
		}

		return projectBlogs;
	}

	/**
	 * 
	 * @param projectBlog
	 */
	@Transactional
	public void save(ProjectBlog projectBlog) {
		// Write the project BLOG to the database
		session().save(projectBlog);
	}

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public ProjectBlog getProjectBlog(String projectId) {
		int pId = Integer.parseInt(projectId);
		return getProjectBlog(pId);
	}

	/**
	 * 
	 * @param pId
	 * @return
	 */
	public ProjectBlog getProjectBlog(int projectId) {
		SimpleExpression seProjectId = Restrictions.eq(IProject.ID, projectId);
		SimpleExpression seActive = Restrictions.eq(IProject.ACTIVE, IProject.YES);
		
		Criteria cr = session().createCriteria(ProjectBlog.class);
		cr.add(seProjectId);
		cr.add(seActive);

		ProjectBlog projectBlog = (ProjectBlog) cr.uniqueResult();
		return projectBlog;
	}

	/**
	 * 
	 * @param pId
	 * @return
	 */
	public boolean deleteProjectBlog(int pId) {
		ProjectBlog projectBlog = getProjectBlog(pId);
		projectBlog.setActive(IProject.NO);
		session().saveOrUpdate(projectBlog);
		return true;
	}
}
