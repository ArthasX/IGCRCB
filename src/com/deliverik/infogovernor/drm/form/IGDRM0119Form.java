package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;


/**
 * 场景触发策略Form
 */
public class IGDRM0119Form extends BaseForm {

	private static final long serialVersionUID = 1L;


	protected Integer rsid;
	/** 场景id */
	protected Integer senceid;

	/** 策略描述 */
	protected String strategyDesc;

	/** 关键字 */
	protected String keyword;

	/** 特殊处理类 */
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
