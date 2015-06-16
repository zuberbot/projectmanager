/**
 * UserMessagesDao
 */
package com.myprojects.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.web.dao.entity.Project;
import com.myprojects.web.dao.entity.UserMessage;
import com.myprojects.web.utility.IProject;
import com.myprojects.web.utility.MyProjectsUtility;

/**
 * @author Chuck
 *
 */
@Repository
@Transactional
@Component(IProject.USER_MESSAGES_DAO)
public class UserMessagesDao extends ProjectsDao {

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<UserMessage> getMessages(String userId) {
		Criteria cr = session().createCriteria(UserMessage.class);
		cr.add(Restrictions.eq(IProject.SENDEE, userId));
		cr.add(Restrictions.eq(IProject.ACTIVE, IProject.YES));
		cr.addOrder(Order.desc(IProject.CREATED_DATE));
		// Set max messages to 10 until you get pagination working
		cr.setMaxResults(10);

		@SuppressWarnings(IProject.UNCHECKED)
		List<UserMessage> userMessages = cr.list();		
		return userMessages;
	}

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public String getUserIdFromProject(String projectId) {
		Integer pId = Integer.parseInt(projectId);
		return getUserIdFromProject(pId);
	}

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public String getUserIdFromProject(int projectId) {
		SimpleExpression seProjectId = Restrictions.eq(IProject.ID, projectId);
		SimpleExpression seEnabled = Restrictions.eq(IProject.ACTIVE, IProject.YES);

		Criteria cr = session().createCriteria(Project.class);
		cr.add(seProjectId);
		cr.add(seEnabled);
		
		Project project = (Project) cr.uniqueResult();
		return project.getProjectOwner();
	}

	/**
	 * 
	 * @param userMessage
	 */
	public void recordUserMessage(UserMessage userMessage) {
		String dateCreated = MyProjectsUtility.getCurrentMySQLDate();		
		userMessage.setCreatedDate(dateCreated);
		userMessage.setActive(IProject.YES);
		session().save(userMessage);
	}
}
