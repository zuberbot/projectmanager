/**
 * ProjectsDao
 */
package com.myprojects.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.web.utility.IProject;

/**
 * @author Chuck
 *
 */
@Repository
@Transactional
@Component(IProject.PROJECTS_DAO)
public class ProjectsDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @return
	 */
	public Session session() {
		return sessionFactory.getCurrentSession();
	}

}
