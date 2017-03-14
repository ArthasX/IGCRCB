package com.deliverik.framework.platform;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzLoaderPlugIn implements PlugIn {

	static Log log = LogFactory.getLog(QuartzLoaderPlugIn.class);
	
	private String quartzConfigLocation = null;
	
	public String getQuartzConfigLocation() {
		return quartzConfigLocation;
	}

	public void setQuartzConfigLocation(String quartzConfigLocation) {
		this.quartzConfigLocation = quartzConfigLocation;
	}

	public void destroy() {
		log.info("shutdown Quartz scheduler started ...");
		try {
			WebApplicationSupport.getScheduler().shutdown();
		} catch (SchedulerException e) {
			log.error("shutdown Quartz scheduler failed ...");
			log.error(e.getStackTrace());
		}
		log.info("shutdown Quartz scheduler finished ...");
	}

	public void init(ActionServlet arg0, ModuleConfig arg1)
			throws ServletException {
		
		log.info("init Quartz scheduler started ...");
		try {
			StdSchedulerFactory factory = new StdSchedulerFactory();
			factory.initialize(arg0.getServletContext().getResourceAsStream(getQuartzConfigLocation()));
						
			Scheduler sche = factory.getScheduler();
			
//			WebApplicationSupport.setSchedulerFactory(factory);
			WebApplicationSupport.setScheduler(sche);
			
			sche.start();
			
		} catch (SchedulerException e) {
			log.error("init Quartz scheduler failed ...");
			log.error(e.getStackTrace());
			throw new ServletException(e);
		} 
		log.info("init Quartz scheduler finished ...");
	}

}
