package com.personal.okta.controller;

import java.time.LocalDateTime;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.personal.okta.model.UserDetail;

@RestController
public class HomeController {

	/**
	 *  UserID : swadeshbehera@example.com
	 *  Password : mindfire
	 * @param user
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String getCurrentUser(@AuthenticationPrincipal OidcUser user, Model model) {

	   UserDetail userDetail = new UserDetail();
	   userDetail.setEmail(user.getEmail());
	   userDetail.setFirstName(user.getGivenName());
	   userDetail.setLastName(user.getFamilyName());
	   userDetail.setLastAccessed(LocalDateTime.now().toString());

		String userStr = "Welcome " + userDetail.getFirstName() + " ! <br>" + "Email : " + userDetail.getEmail()
				+ " <br>" + "Last Accessed : " + userDetail.getLastAccessed();

	return userStr;

	}
	
	@GetMapping("/dl/{age}")
	public String checkForDl(@PathVariable int age, @AuthenticationPrincipal OidcUser user) {
		
		if(age>=18) {
			
			return user.getGivenName()+" is eligible to apply for DL!";
		}else {
			
			return user.getGivenName()+" is not eligible to apply for DL!";
		}
		
	}
	
}
