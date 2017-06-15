package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 应用关系管理画面FORM
 * 
 */
public class IGCIM0126Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 应用ID */
	protected String eiid;
	
	/** 删除应用关系对象 */
	protected String[] deleteEirid;
	
	/**
	 * 应用ID取得
	 * @return 应用ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 应用ID设定
	 *
	 * @param eiid 应用ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除应用关系对象取得
	 * @return 删除应用关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除应用关系对象设定
	 *
	 * @param deleteEirid 删除应用关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
