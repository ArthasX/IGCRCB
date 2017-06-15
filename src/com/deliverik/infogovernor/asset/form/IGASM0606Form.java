package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 软件关系管理画面FORM
 * 
 */
public class IGASM0606Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 软件ID */
	protected String eiid;
	
	/** 删除软件关系对象 */
	protected String[] deleteEirid;
	
	/**
	 * 软件ID取得
	 * @return 软件ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 软件ID设定
	 *
	 * @param eiid 软件ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除软件关系对象取得
	 * @return 删除软件关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除软件关系对象设定
	 *
	 * @param deleteEirid 删除软件关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
