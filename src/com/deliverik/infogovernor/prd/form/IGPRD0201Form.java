/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.form;

import javax.servlet.ServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:用户查询form 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD0201Form extends BaseForm{

	/** 机构码 */
	protected String orgid;
	
	/** 用户姓名 */
	protected String username;

	/**
	 * 机构码取得
	 * @return 机构码
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 机构码设定
	 * @param orgid 机构码
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 用户姓名取得
	 * @return 用户姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 用户姓名设定
	 * @param username 用户姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void reset(ActionMapping mapping, ServletRequest request) {
		super.reset(mapping, request);
		this.orgid = null;
	}
}
