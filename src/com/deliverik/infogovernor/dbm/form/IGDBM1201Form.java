/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.dbm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 科技运行综合分析(一)DashBaord查询结果 form
 * 
 * @author 
 *
 */
public class IGDBM1201Form extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9028486377175964658L;

	/*点击工单数，获得工单数所对应的PRPDID*/
	private String workValue;
	
	private String prtype;
	
	/** 流程定义主键 */
	protected String prpdid;

	public String getWorkValue() {
		return workValue;
	}

	public void setWorkValue(String workValue) {
		this.workValue = workValue;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	
	/**
	 * 流程定义主键取得
	 * @return prpdid 流程定义主键
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 流程定义主键设定
	 * @param prpdid 流程定义主键
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

}
