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
	private final FileStore awsFile;
	
	@Autowired
	public UserProfileDataAccessService(FakeUserProfileDataStore fakeUserProfileDataStore) {
		this.fakeUserProfileDataStore = fakeUserProfileDataStore;
	}
	
	List <UserProfile> getUserProfiles() {
		return fakeUserProfileDataStore.getUserProfiles();
	}
	
	public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
		// 1. Check if image is not empty
		if(file.isEmpty()) {
			throw new IllegalStateException("Cannot upload empty file [ " + file.getSize() + "}");
		}
		// 2. if file is an image
		if(Arrays.asList(ContentType.IMAGE_JPEG, ContentType.IMAGE_PNG, ContentType.IMAGE_GIF)
			.contains(file.getContentType()))
		// 3. the user exists in out database
		// 4. grab some metadata from file if any
		// 5. store the image in s3 and update database with s3 image link
		
		if (!file.isEmpty() && file.getContentType().equals("jpg")) {
			
			List<UserProfile> users = fakeUserProfileDataStore.getUserProfiles();
			try {
				for (UserProfile user : users) {
					if(user.getUserProfileId().equals(userProfileId)) {
						awsFile.save(path, fileName, optionalMetadata, file.getInputStream());
					}
				}
			} catch (Exception e) {
				
			}

		} else {
			throw new UnsupportedOperatingSystemException("There is no valid type of file");
		}
	}
}
