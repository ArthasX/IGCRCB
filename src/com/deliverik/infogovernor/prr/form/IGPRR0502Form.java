/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
  * 概述: 流程组成员列表查询Form
  * 功能描述: 流程组成员列表查询Form
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class IGPRR0502Form extends BaseForm {
	
	/** 流程组ID */
	protected Integer pgrid;

	/**
	 * 流程组ID取得
	 * @return 流程组ID
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 * 流程组ID设定
	 * @param pgrid 流程组ID
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

}