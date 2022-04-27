package com.ssafy.hw0420.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class RootPathListener implements ServletContextListener {

	private Logger log = LoggerFactory.getLogger(RootPathListener.class);

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		log.info("root set...");
		ServletContext ctx = sce.getServletContext();
		ctx.setAttribute("root", ctx.getContextPath());
	}

}
