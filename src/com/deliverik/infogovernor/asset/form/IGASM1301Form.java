package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.IG011SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 设备统计分析信息FORM
 * 
 */
@SuppressWarnings("serial")
public class IGASM1301Form extends BaseForm implements IG011SearchCond{


	/** 开始时间从*/
	protected String ciupdtime_to;
	
	/** 开始时间至 */
	protected String ciupdtime_from;
	
	protected String eiorgsyscoding_q;
	
	protected String eiorgsyscoding_qname;
	
	protected String orgType;//0所属机构 1使用机构
	
	protected String orgname;
	
	/** 资产模型上级层次码*/
	protected String eparcoding;
	
	

	/**
	 * 资产模型上级层次码取得
	 * @return 资产模型上级层次码
	 */
	public String getEparcoding() {
		return eparcoding;
	}

	/**
	 * 资产模型上级层次码设定
	 *
	 * @param eparcoding 资产模型上级层次码
	 */
	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getEiorgsyscoding_q() {
		return eiorgsyscoding_q;
	}

	public String getEiorgsyscoding_qname() {
		return eiorgsyscoding_qname;
	}

	public void setEiorgsyscoding_q(String eiorgsyscoding_q) {
		this.eiorgsyscoding_q = eiorgsyscoding_q;
	}

	public void setEiorgsyscoding_qname(String eiorgsyscoding_qname) {
		this.eiorgsyscoding_qname = eiorgsyscoding_qname;
	}

	public String getCiupdtime_to() {
		return ciupdtime_to;
	}

	public void setCiupdtime_to(String ciupdtime_to) {
		this.ciupdtime_to = ciupdtime_to;
	}

	public String getCiupdtime_from() {
		return ciupdtime_from;
	}

	public void setCiupdtime_from(String ciupdtime_from) {
		this.ciupdtime_from = ciupdtime_from;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}


	
}
