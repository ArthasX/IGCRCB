/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 自定义流程表格类表单预览Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD0173Form extends BaseForm{

	/** 流程定义主键 */
	protected String pdid;
	
	/** 表单定义主键 */
	protected String pidid;

	/**
	 * 流程定义主键取得
	 * @return pdid 流程定义主键
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义主键设定
	 * @param pdid 流程定义主键
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 表单定义主键取得
	 * @return pidid 表单定义主键
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义主键设定
	 * @param pidid 表单定义主键
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}
	
	
}
