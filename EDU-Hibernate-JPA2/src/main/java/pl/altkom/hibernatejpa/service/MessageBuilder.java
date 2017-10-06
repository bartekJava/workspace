package pl.altkom.hibernatejpa.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MessageBuilder {

	private static final AtomicInteger instanceCounter = new AtomicInteger(0);
	
    private final ContentProcessor contentProcessor;
    
    private String content;
    private String receiver;
 
    MessageBuilder(ContentProcessor contentProcessor) {
        this.contentProcessor = contentProcessor;
        instanceCounter.incrementAndGet();
    }
 
    public static int getInstanceCounter() {
        return instanceCounter.get();
    }
	
    MessageBuilder withContent(String content) {
        this.content = contentProcessor.process(content);
        return this;
    }
 
    MessageBuilder withReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }
 
    Message build() {
        return new Message(content, receiver);
    }

}