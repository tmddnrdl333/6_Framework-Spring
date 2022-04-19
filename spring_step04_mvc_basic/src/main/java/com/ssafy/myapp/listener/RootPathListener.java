package com.ssafy.myapp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RootPathListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent sce)  { 
    }
    public void contextInitialized(ServletContextEvent sce)  {
    	ServletContext ctx = sce.getServletContext();
    	ctx.setAttribute("root", ctx.getContextPath());
    }
	
}
