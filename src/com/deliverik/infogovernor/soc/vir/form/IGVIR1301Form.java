/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚机资源管理Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1301Form extends BaseForm{

	/** vCenter名称 */
	protected Integer vcid;
	
	/** 主机名称 */
	protected String hostname;

	/**
	 * vCenter名称取得
	 * @return vcid vCenter名称
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCenter名称设定
	 * @param vcid vCenter名称
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * 主机名称取得
	 * @return hostname 主机名称
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * 主机名称设定
	 * @param hostname 主机名称
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
}
