package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;


/**
 * 场景制度管理 IGCOM0101Form ActionForm
 */
public class IGDRM0105Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String  einame ; // 资产名称
	private String  ename ; // 资产编号
	private String  eilabel ; // 资产编号
	private String  eiinsdate_ge ;// 资产登记日大于等于
	private String  eiinsdate_le ;// 资产登记日 小于等于
	private String  eiorgsyscoding ; // 资产所属机构层次码
	private String orgname;
	private String  esyscoding ; // 资产模型层次码
	private String  eiuserid ; // 资产管理人
	private String  eiusername ; // 资产管理人姓名
	private String eparcoding; // 父级层次码


	public String getEparcoding() {
		return eparcoding;
	}

	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}
	/** 设备ID */
	protected String eiid;
	/** 预案修改提醒周期 */
	protected String cycleTime;
	
	/**模糊匹配预案的文本框类属性*/
	private String planContent;
	/** 存储过滤like*/
	protected String esyscoding_like;
	
	public String getEsyscoding_like() {
		return esyscoding_like;
	}
	public void setEsyscoding_like(String esyscoding_like) {
		this.esyscoding_like = esyscoding_like;
	}
	public String getEiname() {
		return einame;
	}
	public void setEiname(String einame) {
		this.einame = einame;
	}
	public String getEilabel() {
		return eilabel;
	}
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}
	public String getEiinsdate_ge() {
		return eiinsdate_ge;
	}
	public void setEiinsdate_ge(String eiinsdate_ge) {
		this.eiinsdate_ge = eiinsdate_ge;
	}
	public String getEiinsdate_le() {
		return eiinsdate_le;
	}
	public void setEiinsdate_le(String eiinsdate_le) {
		this.eiinsdate_le = eiinsdate_le;
	}
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	public String getEiuserid() {
		return eiuserid;
	}
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	public String getEiusername() {
		return eiusername;
	}
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getPlanContent() {
		return planContent;
	}
	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}
	public String getEiid() {
		return eiid;
	}
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	public String getCycleTime() {
		return cycleTime;
	}
	public void setCycleTime(String cycleTime) {
		this.cycleTime = cycleTime;
	}
	
}
