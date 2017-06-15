/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 部署进度画面FORM
 * 
 */
public class IGVIR0203Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
    /** 流程主键 */
    protected String prid;

	/**
	 * 流程主键取得
	 * @return prid 流程主键
	 */
	public String getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 * @param prid 流程主键
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}
    
}
