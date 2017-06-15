package com.deliverik.framework.platform;

import javax.servlet.http.HttpServlet;

import org.quartz.Scheduler;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.struts.ContextLoaderPlugIn;

public class WebApplicationSupport {
	
	public static HttpServlet strutsServlet = null;
	
	public static Scheduler scheduler = null;
	
	public static Scheduler getScheduler() {
		return scheduler;
	}

	public static void setScheduler(Scheduler scheduler) {
		WebApplicationSupport.scheduler = scheduler;
	}

	public static void initWebApplicationSupport(HttpServlet servlet) {
		setStrutsServlet(servlet);
	}

	public static WebApplicationContext getWebApplicationContext() {

		WebApplicationContext wac = null;
		
		wac = (WebApplicationContext) getStrutsServlet().getServletContext().getAttribute(
					ContextLoaderPlugIn.SERVLET_CONTEXT_PREFIX);

		return wac;
	}
	
	public static Object getBean(String name) {
		return getWebApplicationContext().getBean(name);
	}

	public static HttpServlet getStrutsServlet() {
		return strutsServlet;
	}

	public static void setStrutsServlet(HttpServlet strutsServlet) {
		WebApplicationSupport.strutsServlet = strutsServlet;
	}
	
	
}
