package pl.altkom.hibernatejpa.edu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import pl.altkom.hibernatejpa.model.User;
import pl.altkom.hibernatejpa.service.MessageService;
import pl.altkom.hibernatejpa.service.MessageBuilder;
import pl.altkom.hibernatejpa.utils.Profile;

@SpringBootTest
public class EduSpringRequirementsTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
    private MessageService messageService;
	
	
	@Test
	void schouldRetrieveUserNameAdmin() {
		String userName = "Admin";
		
		Profile profile = (Profile) context.getBean("profile");
		User user = profile.getUser();
		
		Assert.assertEquals(user.getFirstName(), userName);
	}
	
	@Test
	void shouldCreateTwoBuilders() throws Exception {
		int numberOfPrototypeBeansCreated = 2;
		
		messageService.createMessage("text", "John");
		messageService.createMessage("text", "Jane");
		int prototypeCounter = MessageBuilder.getInstanceCounter();
		
		Assert.assertEquals(prototypeCounter, numberOfPrototypeBeansCreated);
	}

}
