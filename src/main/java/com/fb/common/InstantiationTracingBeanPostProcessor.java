package com.fb.common;

import com.fb.util.AppConfig;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/8/2.
 */
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

    Logger logger = LoggerFactory.getLogger(InstantiationTracingBeanPostProcessor.class);


    @Autowired
    private AppConfig appConfig;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        // init function when begin the project
    }
}
