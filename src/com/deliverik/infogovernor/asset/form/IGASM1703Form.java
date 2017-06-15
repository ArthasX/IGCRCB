package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 组件基本信息成功登录后确认画面FORM
 * 
 */
public class IGASM1703Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	/** 组件ID */
	protected Integer eiid;

	/**
	 * 组件ID取得
	 * @return 组件ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 组件ID设定
	 *
	 * @param eiid 组件ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}
