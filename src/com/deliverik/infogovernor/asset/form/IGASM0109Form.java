package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 资产下拉数据选择画面FORM
 * 
 */
public class IGASM0109Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String ccdcategory;
	private String ccdlabel;

	public String getCcdcategory() {
		return ccdcategory;
	}

	public void setCcdcategory(String ccdcategory) {
		this.ccdcategory = ccdcategory;
	}

	public String getCcdlabel() {
		return ccdlabel;
	}

	public void setCcdlabel(String ccdlabel) {
		this.ccdlabel = ccdlabel;
	}

}
