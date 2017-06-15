package com.deliverik.infogovernor.scheduling.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.deliverik.infogovernor.util.HQUtil;

public class CollectJobListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		HQUtil HQUtil = new HQUtil();
		try {
			//HQUtil.getHQApi();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
