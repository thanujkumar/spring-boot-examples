package com.app.event2;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;


public class ListenerBean implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("event: " + event);
    }
}