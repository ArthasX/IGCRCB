package com.deliverik.infogovernor.adapter;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;

/**
 * 概述: AD集成用户校验
 * 功能描述: AD集成用户校验
 * 创建记录: 2012-5-24
 * 修改记录: 
 */

public class ADAdapter {
	
	// AD服务器IP
	private static String AD_URL = null;
	// AD域
	private static String AD_DOMAIN = null;
	
	public static ADAdapter getInstance() {
		return new ADAdapter();
	}

	protected ADAdapter() {
	}

	public boolean adAuthorize(String userName,String password) {
		
		boolean flag = false;
		
		CodeListUtils ctlBL = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		
		if(AD_URL == null || "".equals(AD_URL)){
			AD_URL = ctlBL.getCodeValue(CodeDefinition.AD, "", "", CodeDefinition.AD_URL);
		}
		
		if(AD_DOMAIN == null || "".equals(AD_DOMAIN)){
			AD_DOMAIN = ctlBL.getCodeValue(CodeDefinition.AD, "", "", CodeDefinition.AD_DOMAIN);
		}

		String port = "389"; // 端口

		String url = new String("ldap://" + AD_URL + ":" + port);

		String user = userName.indexOf(AD_DOMAIN) > 0 ? userName : userName
				+ AD_DOMAIN;

		Hashtable<String, String> env = new Hashtable<String, String>();

		env.put(Context.SECURITY_AUTHENTICATION, "simple");

		env.put(Context.SECURITY_PRINCIPAL, user); 

		env.put(Context.SECURITY_CREDENTIALS, password);

		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");

		env.put(Context.PROVIDER_URL, url);

		try {
			
			new InitialDirContext(env);
			
			flag = true;

		} catch (NamingException err) {

			return flag;

		} 
		
		return flag;
	}

}
