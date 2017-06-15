package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 检查项基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM2803Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 检查项ID */
	protected Integer eiid;

	/**
	 * 检查项ID取得
	 * @return 检查项ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 检查项ID设定
	 *
	 * @param eiid 检查项ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
