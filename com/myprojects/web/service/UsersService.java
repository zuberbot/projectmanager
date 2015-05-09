/**
 * UsersService
 */
package com.myprojects.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myprojects.web.dao.UsersDao;
import com.myprojects.web.dao.entity.User;
import com.myprojects.web.utility.IProject;
import com.myprojects.web.utility.MyProjectsUtility;

/**
 * @author Chuck
 *
 */
@Component(IProject.USERS_SERVICE)
public class UsersService {

	@Autowired
	private UsersDao usersDao;	

	/**
	 * 
	 * @param user
	 */
	public void create(User user) {
		String dateCreated = MyProjectsUtility.getCurrentMySQLDate();
		user.setCreatedDate(dateCreated);
		user.setUpdatedLastDate(dateCreated);
		usersDao.create(user);
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	public boolean exists(String username) {
		return usersDao.exists(username);
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	public User getUser(String username) {
		return usersDao.getUser(username);
	}
}
