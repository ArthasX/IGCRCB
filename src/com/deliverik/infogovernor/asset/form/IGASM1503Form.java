package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 人员基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM1503Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 人员ID */
	protected Integer eiid;

	/**
	 * 人员ID取得
	 * @return 人员ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 人员ID设定
	 *
	 * @param eiid 人员ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
