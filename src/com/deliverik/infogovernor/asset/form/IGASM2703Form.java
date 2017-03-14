package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 风险点基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM2703Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 风险点ID */
	protected Integer eiid;

	/**
	 * 风险点ID取得
	 * @return 风险点ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 风险点ID设定
	 *
	 * @param eiid 风险点ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
