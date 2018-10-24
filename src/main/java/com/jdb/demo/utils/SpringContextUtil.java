package com.jdb.demo.utils;

import org.apache.activemq.ActiveMQConnection;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class SpringContextUtil {

    // Spring应用上下文环境  
    private static ApplicationContext applicationContext;
    /**
     * @return ApplicationContext
     */
    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    private static final String BROKEN_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    /** 
     * 获取对象 
     *  
     * @param name 
     * @return Object
     */  
    public static Object getBean(String name) {

        if(getApplicationContext() == null){
            setApplicationContext();
        }
        return applicationContext.getBean(name);  
    }  
    
    /**
     * 功能: 获取对象
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        if(getApplicationContext() == null){
            setApplicationContext();
        }
        return applicationContext.getBean(clazz);
    }


    public static <T> T getBean(String name, Class<T> requiredType)
            throws BeansException {
        if(getApplicationContext() == null){
            setApplicationContext();
        }
        return applicationContext.getBean(name, requiredType);
    }

    private static void setApplicationContext() throws BeansException {
        applicationContext = org.springframework.web.context.ContextLoader
                .getCurrentWebApplicationContext();
    }
}