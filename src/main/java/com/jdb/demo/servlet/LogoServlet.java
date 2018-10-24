package com.jdb.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/servlet",name = "LogoServlet")
public class LogoServlet extends HttpServlet {

    int i = 0;

    @Override
    public void init() throws ServletException {
        super.init();
        System.err.println("初始化LogoServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.err.println("LogoServlet-doGet"+(i++));
        resp.getWriter().print("LogoServlet-doGet");
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        System.err.println("LogoServlet-doPost");
    }

}
