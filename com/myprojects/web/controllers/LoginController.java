/**
 * LoginController
 */
package com.myprojects.web.controllers;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import com.myprojects.web.dao.entity.User;
import com.myprojects.web.service.UsersService;
import com.myprojects.web.utility.IProject;

/**
 * @author Chuck
 *
 */
@Controller
public class LoginController extends ProjectsController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
    ReCaptchaImpl reCaptcha;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(IProject.LOGIN_PATH)
	public String showLogin() {
		return IProject.LOGIN;
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(IProject.LOGGED_OUT_PATH)
	public String showLoggedOut(Model model) {
		model.addAttribute(IProject.LOGGED_OUT, IProject.LOGGED_OUT_MSG);
		return IProject.HOME;
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(IProject.NEW_ACCOUNT_PATH)
	public String showNewAccount(Model model) {
		model.addAttribute(IProject.USER, new User());
		return IProject.NEW_ACCOUNT;
	}

	/**
	 * 
	 * @param model
	 * @param user
	 * @param result
	 * @param challangeField
	 * @param responseField
	 * @param servletRequest
	 * @return
	 */
	@RequestMapping(value=IProject.CREATE_ACCOUNT, method=RequestMethod.POST)
	public String createAccount(Model model, @Valid User user, BindingResult result, 
			@RequestParam(IProject.CAPTCHA_CHALLENGE) String challangeField, 
			@RequestParam(IProject.CAPTCHA_RESPONSE) String responseField, 
			ServletRequest servletRequest) {
		
		// http://www.codingpedia.org/ama/recaptcha-and-spring-mvc-integration/
		String remoteAddress = servletRequest.getRemoteAddr();
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddress, challangeField, responseField);
		
		if (!reCaptchaResponse.isValid()) {
			result.rejectValue(IProject.CAPTCHA_INVALID, IProject.INVALID_CAPTCHA);
			return IProject.NEW_ACCOUNT;
		}

		if (result.hasErrors()) {
			return IProject.NEW_ACCOUNT;
		}

		// Check to see if this user already exists
		if (usersService.exists(user.getUserName())) {
			result.rejectValue(IProject.USER_NAME, IProject.DUP_KEY_USER_NAME);
			return IProject.NEW_ACCOUNT;
		}

		user.setEnabled(true);
		user.setAuthority(IProject.ROLE_USER);

		try {
			// Create the new user account
			usersService.create(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue(IProject.USER_NAME_LOWER, IProject.DUP_KEY_USER_NAME, IProject.USER_ALREADY_EXISTS);
			return IProject.NEW_ACCOUNT;
		}

		return IProject.ACCOUNT_CREATED; // to tile
	}
}
