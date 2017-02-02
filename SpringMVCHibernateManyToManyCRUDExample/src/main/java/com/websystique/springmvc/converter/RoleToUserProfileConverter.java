package com.websystique.springmvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.UserProfileService;

@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile>
{
	/*'element' String comes from itemValue="id" -> registration.jsp
	
	When you click on register, Spring will try to populate the model object [User] with user input's, populating the 
	properties referred using 'path' attribute. Since within jsp, we just have String[itemValue='id'], spring will try 
	to convert the selected ids[ list of strings] to userProfiles [referred via 'path']. Since we have registered a custom 
	converter, spring will be able to convert id to user profile[& eventually populate User.userProfiles.*/
	@Autowired
	UserProfileService userProfileService;

	public UserProfile convert(Object element) 
	{
		Integer id = Integer.parseInt((String)element);
		UserProfile profile = userProfileService.findById(id);
		System.out.println("Profile : "+profile);
		return profile;
	}

}
