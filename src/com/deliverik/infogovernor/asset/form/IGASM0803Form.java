package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 应用基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM0803Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 应用ID */
	protected Integer eiid;

	/**
	 * 应用ID取得
	 * @return 应用ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 应用ID设定
	 *
	 * @param eiid 应用ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
