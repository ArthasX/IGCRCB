package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 机柜基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM1203Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 机柜ID */
	protected Integer eiid;

	/**
	 * 机柜ID取得
	 * @return 机柜ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 机柜ID设定
	 *
	 * @param eiid 机柜ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
