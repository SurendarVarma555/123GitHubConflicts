package com.vidvaan.event.handler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class ContextStoppedEventHandler implements ApplicationListener<ContextStoppedEvent> {

	@Override
	public void onApplicationEvent(ContextStoppedEvent cse) {
		System.out.println("ContextStoppedEvent received");
		System.out.println(cse.getSource());
		System.out.println("--------------------------------------");
	}

}
