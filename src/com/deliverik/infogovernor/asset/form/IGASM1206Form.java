package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 机柜关系管理画面FORM
 * 
 */
public class IGASM1206Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 机柜ID */
	protected String eiid;
	
	/** 删除机柜关系对象 */
	protected String[] deleteEirid;
	
	/**
	 * 机柜ID取得
	 * @return 机柜ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 机柜ID设定
	 *
	 * @param eiid 机柜ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除机柜关系对象取得
	 * @return 删除机柜关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除机柜关系对象设定
	 *
	 * @param deleteEirid 删除机柜关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
