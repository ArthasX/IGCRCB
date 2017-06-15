package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 合同基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM0403Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 合同ID */
	protected Integer eiid;

	/**
	 * 合同ID取得
	 * @return 合同ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 合同ID设定
	 *
	 * @param eiid 合同ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
