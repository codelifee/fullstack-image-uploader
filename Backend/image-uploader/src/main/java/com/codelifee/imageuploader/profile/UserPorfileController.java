package com.codelifee.imageuploader.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user-profile")
public class UserPorfileController {

	private final UserProfileDataAccessService userProfileService;
	
	
	@Autowired
	public UserPorfileController(UserProfileDataAccessService userProfileService) {
		super();
		this.userProfileService = userProfileService;
	}


	@GetMapping
	public List<UserProfile> getUserProfile() {
		return userProfileService.getUserProfiles();
	}
	
}
