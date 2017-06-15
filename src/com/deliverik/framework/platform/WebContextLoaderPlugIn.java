package com.deliverik.framework.platform;

import javax.servlet.ServletException;

import org.springframework.web.struts.ContextLoaderPlugIn;

public class WebContextLoaderPlugIn extends ContextLoaderPlugIn {

	protected void onInit() throws ServletException {
		WebApplicationSupport.initWebApplicationSupport(getActionServlet());
	}
	
}
