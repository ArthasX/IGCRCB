package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 发票基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM2403Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 发票ID */
	protected Integer eiid;

	/**
	 * 发票ID取得
	 * @return 发票ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 发票ID设定
	 *
	 * @param eiid 发票ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
