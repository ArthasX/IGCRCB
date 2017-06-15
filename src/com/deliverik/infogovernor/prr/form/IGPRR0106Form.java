/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 表单日志查看Form
 * @Author  
 * @History 2010-9-17     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0106Form extends BaseForm {
	
	/** 流程日志ID */
	protected Integer rlid;

	
	/**
	 * 流程日志ID取得
	 * @return 流程日志ID
	 */
	public Integer getRlid() {
		return rlid;
	}

	/**
	 * 流程日志ID设定
	 * @param rlid 流程日志ID
	 */
	public void setRlid(Integer rlid) {
		this.rlid = rlid;
	}

	
}
