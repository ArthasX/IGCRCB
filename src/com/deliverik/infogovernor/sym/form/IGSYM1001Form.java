package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 数据分类列表画面FORM
 *  
 */
public class IGSYM1001Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** 数据分类CD */
	protected String ccid ;
	
	/**
	 * 数据分类CD取得
	 * @return 数据分类CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * 数据分类CD设定
	 *
	 * @param ccid 数据分类CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

}
