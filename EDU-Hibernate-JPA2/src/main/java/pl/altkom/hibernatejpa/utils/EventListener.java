package pl.altkom.hibernatejpa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener implements ApplicationListener<CustomEvent> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EventListener.class);

	@Override
	public void onApplicationEvent(CustomEvent event) {
		
		System.out.println("Received spring custom event - " + event.getMessage());
		LOGGER.info(event.getMessage());
	}

}
