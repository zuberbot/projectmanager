/**
 * UsersDao
 */
package com.myprojects.web.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.web.dao.entity.User;
import com.myprojects.web.utility.IProject;

/**
 * @author Chuck
 *
 */
@Repository
@Transactional
@Component(IProject.USERS_DAO)
public class UsersDao extends ProjectsDao {

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * 
	 * @param user
	 */
	@Transactional
	public void create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);		
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public boolean exists(String userName) {
		Criteria cr = session().createCriteria(User.class);
		cr.add(Restrictions.eq(IProject.USER_NAME, userName));
		cr.add(Restrictions.eq(IProject.ENABLED, true));
		User user = (User) cr.uniqueResult();
		
		if (user != null) {
			String usrNm = user.getUserName();
			
			if (!"".equals(usrNm) && userName.equals(usrNm)) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	public User getUser(String userName) {
		// Leave an HQL call to see difference with Criteria
		Query query = session().createQuery(IProject.USER_QUERY);
		query.setString(IProject.USER_NAME, userName);
		User user = (User) query.uniqueResult();
		
		if (user != null) {
			return user;
		}
		
		return null;
	}	
}
