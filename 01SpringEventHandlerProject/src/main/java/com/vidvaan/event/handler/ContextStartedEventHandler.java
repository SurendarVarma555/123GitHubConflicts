package com.vidvaan.event.handler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class ContextStartedEventHandler implements ApplicationListener<ContextStartedEvent> {

	@Override
	public void onApplicationEvent(ContextStartedEvent cse) {
		System.out.println("ContextStartedEvent received...");
		System.out.println(cse.getSource());
		System.out.println("----------------------------");
	}

}
