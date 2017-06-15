/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 报告附加Form
 * 功能描述: 
 * 创建记录:杨龙全 2012/06/13
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT0207Form extends BaseForm{
	
	/** 附件IDS */
	protected String[] anIds;
	
	/**报告ID*/
	protected Integer rmId;
	/**确认删除吗*/
	protected String isDel;
	/**
	 * 附件IDS取得
	 *
	 * @return anIds 附件IDS
	 */
	public String[] getAnIds() {
		return anIds;
	}

	/**
	 * 附件IDS设定
	 *
	 * @param anIds 附件IDS
	 */
	public void setAnIds(String[] anIds) {
		this.anIds = anIds;
	}

	/**
	 * 报告ID取得
	 *
	 * @return rmId 报告ID
	 */
	public Integer getRmId() {
		return rmId;
	}

	/**
	 * 报告ID设定
	 *
	 * @param rmId 报告ID
	 */
	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}

	/**
	 * 确认删除吗取得
	 *
	 * @return isDel 确认删除吗
	 */
	public String getIsDel() {
		return isDel;
	}

	/**
	 * 确认删除吗设定
	 *
	 * @param isDel 确认删除吗
	 */
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	
	
}
