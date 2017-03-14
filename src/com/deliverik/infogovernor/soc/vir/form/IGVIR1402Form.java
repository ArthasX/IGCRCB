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
 * Description: 资源使用情况统计Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1402Form extends BaseForm{

	/** vCenter连接ID */
	protected Integer vcid;
	
	/** 主机IP */
	protected String hostname;

	/**
	 * vCenter连接ID取得
	 * @return vcid vCenter连接ID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCenter连接ID设定
	 * @param vcid vCenter连接ID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * 主机IP取得
	 * @return hostname 主机IP
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * 主机IP设定
	 * @param hostname 主机IP
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
}
