package com.codelifee.imageuploader.datastore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.codelifee.imageuploader.profile.UserProfile;

@Repository
public class FakeUserProfileDataStore {

	private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

	static {
		USER_PROFILES.add(new UserProfile(UUID.fromString("294631d1-1bed-4d91-95bd-3b944bb20ed2"), "janetjones", null));
		USER_PROFILES.add(new UserProfile(UUID.fromString("1bf31ab5-7fcc-4735-9c6b-6b50f66cd583"), "antoniojunior", null));
	}
	
	public List<UserProfile> getUserProfiles() {
		return USER_PROFILES;
	}
	
	
}
