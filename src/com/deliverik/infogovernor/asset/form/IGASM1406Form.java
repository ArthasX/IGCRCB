package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 设备关系管理画面FORM
 * 
 */
public class IGASM1406Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** 服务记录ID */
	protected String eiid;
	
	/** 删除服务记录关系对象 */
	protected String[] deleteEirid;
	
	/**
	 * 服务记录ID取得
	 * @return 服务记录ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 服务记录ID设定
	 *
	 * @param eiid 服务记录ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 删除服务记录关系对象取得
	 * @return 删除服务记录关系对象
	 */
	public String[] getDeleteEirid() {
		return deleteEirid;
	}

	/**
	 * 删除服务记录关系对象设定
	 *
	 * @param deleteEirid 删除服务记录关系对象
	 */
	public void setDeleteEirid(String[] deleteEirid) {
		this.deleteEirid = deleteEirid;
	}
}
