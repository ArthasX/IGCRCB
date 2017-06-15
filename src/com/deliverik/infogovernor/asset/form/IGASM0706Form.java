package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 机房关系管理画面FORM
 * 
 */
public class IGASM0706Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 机房ID */
	protected String eiid;
	
	/** 删除机房关系对象 */
	protected String[] deleteEirid;
	
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
	 * 删除机房关系对象取得
	 * @return 删除机房关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除机房关系对象设定
	 *
	 * @param deleteEirid 删除机房关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
