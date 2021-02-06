package com.codelifee.imageuploader.profile;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.simplesystemsmanagement.model.UnsupportedOperatingSystemException;
import com.codelifee.imageuploader.datastore.FakeUserProfileDataStore;
import com.codelifee.imageuploader.filestore.FileStore;

@Repository
public class UserProfileDataAccessService {

	private final FakeUserProfileDataStore fakeUserProfileDataStore;
	
	@Autowired
	public UserProfileDataAccessService(FakeUserProfileDataStore fakeUserProfileDataStore) {
		this.fakeUserProfileDataStore = fakeUserProfileDataStore;
	}
	
	List <UserProfile> getUserProfiles() {
		return fakeUserProfileDataStore.getUserProfiles();
	}

}
