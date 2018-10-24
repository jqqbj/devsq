package com.jdb.demo.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ReqListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.err.println("初始化ReqListener");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.err.println("销毁ReqListener");
    }

}
