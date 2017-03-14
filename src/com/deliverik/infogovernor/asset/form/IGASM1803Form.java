package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 系统基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM1803Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 系统ID */
	protected Integer eiid;

	/**
	 * 系统ID取得
	 * @return 系统ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 系统ID设定
	 *
	 * @param eiid 系统ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
