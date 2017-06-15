package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 机柜选择画面FORM
 * 
 */
public class IGASM1111Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 删除机房对象 */
	protected String[] deleteEiid;
	
	/** 所属机柜Id */
	protected String computerContainerId;
	
	/**
	 * 删除机房对象取得
	 * @return 删除机房对象
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}


	/**
	 * 删除机房对象设定
	 *
	 * @param deleteEiid 删除机房对象
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 *所属机柜Id取得
	 * @return 所属机柜Id
	 */
	public String getComputerContainerId() {
		return computerContainerId;
	}
	/**
	 * 所属机柜Id设定
	 *
	 * @param computerContainerId 所属机柜Id
	 */
	public void setComputerContainerId(String computerContainerId) {
		this.computerContainerId = computerContainerId;
	}
	

}
