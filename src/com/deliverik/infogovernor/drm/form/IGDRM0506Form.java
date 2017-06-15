package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 文档关系管理画面FORM
 * 
 */
public class IGDRM0506Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 文档ID */
	protected String eiid;
	
	/** 删除文档关系对象 */
	protected String[] deleteEirid;
	
	/**
	 * 文档ID取得
	 * @return 文档ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 文档ID设定
	 *
	 * @param eiid 文档ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除文档关系对象取得
	 * @return 删除文档关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除文档关系对象设定
	 *
	 * @param deleteEirid 删除文档关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
