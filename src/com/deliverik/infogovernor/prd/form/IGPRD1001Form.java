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
 * Description: 流程定义查询Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD1001Form extends BaseForm{

	/** 流程定义模板ID */
	protected Integer ptid;

	/**
	 * 流程定义模板ID取得
	 * @return ptid 流程定义模板ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * 流程定义模板ID设定
	 * @param ptid 流程定义模板ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}
}
