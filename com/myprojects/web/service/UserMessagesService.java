/**
 * UserMessagesService
 */
package com.myprojects.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myprojects.web.dao.UserMessagesDao;
import com.myprojects.web.dao.entity.UserMessage;

import com.myprojects.web.utility.IProject;

/**
 * @author Chuck
 *
 */
@Component(IProject.USER_MESSAGES_SERVICE)
public class UserMessagesService {

	@Autowired
	private UserMessagesDao userMessagesDao;
	
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public String getUserId(String projectId) {
		return userMessagesDao.getUserIdFromProject(projectId);
	}

	/**
	 * 
	 * @param userMessage
	 */
	public void sendUserMessage(UserMessage userMessage) {
		userMessagesDao.recordUserMessage(userMessage);		
	}

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<UserMessage> getUserMessages(String userId) {
		return userMessagesDao.getMessages(userId);
	}

}
