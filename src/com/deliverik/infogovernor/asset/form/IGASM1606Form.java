package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 数据关系管理画面FORM
 * 
 */
public class IGASM1606Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 数据ID */
	protected String eiid;
	
	/** 删除数据关系对象 */
	protected String[] deleteEirid;
	
	/**
	 * 数据ID取得
	 * @return 数据ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 数据ID设定
	 *
	 * @param eiid 数据ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除数据关系对象取得
	 * @return 删除数据关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除数据关系对象设定
	 *
	 * @param deleteEirid 删除数据关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
