package com.vidvaan.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vidvaan.CustomEventPublisher;

public class Test {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		CustomEventPublisher customEventPublisher = ctx.getBean("customEventPublisher", CustomEventPublisher.class);
		customEventPublisher.publicevent();
		ctx.close();

	}

}
