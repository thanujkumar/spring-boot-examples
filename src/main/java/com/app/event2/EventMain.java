package com.app.event2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EventMain {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication sa = new SpringApplication(EventMain.class);
        sa.addListeners(new ListenerBean());
        ConfigurableApplicationContext context = sa.run(args);
        MyBean bean = context.getBean(MyBean.class);
        bean.doSomething();
    }
}