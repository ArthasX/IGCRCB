package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 系统关系管理画面FORM
 * 
 */
public class IGASM1806Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 系统ID */
	protected String eiid;
	
	/** 删除系统关系对象 */
	protected String[] deleteEirid;
	
	/**
	 * 系统ID取得
	 * @return 系统ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 系统ID设定
	 *
	 * @param eiid 系统ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除系统关系对象取得
	 * @return 删除系统关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除系统关系对象设定
	 *
	 * @param deleteEirid 删除系统关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
