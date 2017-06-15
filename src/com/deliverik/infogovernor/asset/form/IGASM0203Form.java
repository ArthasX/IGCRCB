package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 资产项基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM0203Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 资产项ID */
	protected Integer eiid;

	/**
	 * 资产项ID取得
	 * @return 资产项ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产项ID设定
	 *
	 * @param eiid 资产项ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
