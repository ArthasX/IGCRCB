package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;


/**
 * ������������Form
 */
public class IGDRM0119Form extends BaseForm {

	private static final long serialVersionUID = 1L;


	protected Integer rsid;
	/** ����id */
	protected Integer senceid;

	/** �������� */
	protected String strategyDesc;

	/** �ؼ��� */
	protected String keyword;

	/** ���⴦���� */
	protected String handleBL;
	
	protected String rsargs;
	
	

	public String getRsargs() {
		return rsargs;
	}

	public void setRsargs(String rsargs) {
		this.rsargs = rsargs;
	}

	public Integer getSenceid() {
		return senceid;
	}

	public void setSenceid(Integer senceid) {
		this.senceid = senceid;
	}

	public String getStrategyDesc() {
		return strategyDesc;
	}

	public void setStrategyDesc(String strategyDesc) {
		this.strategyDesc = strategyDesc;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getHandleBL() {
		return handleBL;
	}

	public void setHandleBL(String handleBL) {
		this.handleBL = handleBL;
	}

	public Integer getRsid() {
		return rsid;
	}

	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}
	
}
