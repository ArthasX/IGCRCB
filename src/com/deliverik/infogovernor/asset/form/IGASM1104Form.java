package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 机房平面图画面FORM
 * 
 */
public class IGASM1104Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 机房ID */
	protected String eiid;
	
	/** 机柜ID */
	protected String container_eiid;
	
	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 机房ID设定
	 *
	 * @param eiid 机房ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 机柜ID取得
	 * @return 机柜ID
	 */
	public String getContainer_eiid() {
		return container_eiid;
	}

	/**
	 * 机柜ID设定
	 *
	 * @param container_eiid 机柜ID
	 */
	public void setContainer_eiid(String container_eiid) {
		this.container_eiid = container_eiid;
	}
}
