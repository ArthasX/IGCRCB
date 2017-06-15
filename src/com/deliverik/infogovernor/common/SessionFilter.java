package com.deliverik.infogovernor.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.security.UserPermissionBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;

public class SessionFilter implements Filter {
	protected FilterConfig filterConfig;
	private String loginPage;
	private String permUri;

	public void init(FilterConfig conf) throws ServletException {
		this.filterConfig = conf;
		loginPage = conf.getInitParameter("loginPage");
		permUri = conf.getInitParameter("permUri");
		if (loginPage == null || permUri == null) {
			throw new ServletException("服务器异常！");
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		req.setCharacterEncoding("utf-8");
		String requesturi = req.getRequestURI();
		String[] uri = permUri.split(",");
		if (uri == null || uri.length == 0) {
			throw new ServletException("服务器异常！");
		}
		boolean perm = false;
		for (int i = 0; i < uri.length; i++) {
			if(requesturi.indexOf("IGCOM0101.do;jsessionid")!=-1){
				requesturi = requesturi.split(";")[0];
			}
			if (requesturi.endsWith(uri[i])) {
				perm = true;
				break;
			}
		}
		String platformuserid = req.getParameter("platformuserid");
		
		User user = (User) req.getSession().getAttribute(BaseAction.SESSION_KEY_LOGIN_USER);
		boolean flag = true;
		if(StringUtils.isNotEmpty(platformuserid)){
			if(null!=user&&!platformuserid.equals(user.getUserid())){
				flag = false;
			}
		}
		
		if (perm || user != null) {
			chain.doFilter(request, response);
		}else if(StringUtils.isNotEmpty(platformuserid)){
			UserBL userBL = (UserBL) WebApplicationSupport.getBean("userBL");
			UserPermissionBL userPermissionBL = (UserPermissionBL) WebApplicationSupport.getBean("userPermissionBL");
			try {
				User platformuser = userBL.searchUserByKey(platformuserid);
				req.getSession().setAttribute(BaseAction.SESSION_KEY_LOGIN_USER, platformuser);
				UserPermission permission = userPermissionBL.initUserPermission(platformuserid);
				req.getSession().setAttribute("UserPermission", permission);
				chain.doFilter(request, response);
			} catch (BLException e) {
				e.printStackTrace();
			}
			
		} else {
			rep.sendRedirect(loginPage);
		}
	}

	public void destroy() {

	}
}
