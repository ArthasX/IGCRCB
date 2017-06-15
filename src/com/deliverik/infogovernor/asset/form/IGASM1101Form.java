package com.deliverik.infogovernor.asset.form;



import com.deliverik.framework.base.BaseForm;

/**
 * 机房查询画面FORM
 * 
 */
public class IGASM1101Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** 删除机房对象 */
	protected String[] deleteEiid;
	
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

}
