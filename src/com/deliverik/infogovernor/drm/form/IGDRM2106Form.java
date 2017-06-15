package com.deliverik.infogovernor.drm.form;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * 设备编辑画面FORM
 * 
 */
public class IGDRM2106Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	private String esyscoding;
	
	private String pdid;

	private String ename;
	
	private String eid ; // 资产模型ID
	private String eidesc ; // 资产说明
	private String einame ; // 资产名称
	private String eilabel ; // 资产编号
	private String eiinsdate ;// 资产登记日
	private String eiorgsyscoding ; // 资产所属机构层次码
	private String eiorgname; // 资产所属机构名称
	private String eiupdtime ; // 资产更新时间
	private String eistatus ; // 资产状态
	private String estatus ; // 模型状态
	private Integer eiversion ; // 资产版本号
	private String fingerprint ; // 时间戳
	private String eiuserid ; // 资产管理人
	private String eiusername ; // 资产管理人姓名
	private Integer eismallversion; // 资产小版本
	private Integer eirootmark ; // 资产所属树根节点实体标识
	private String[] cids;
	private Integer eiid;
	protected String[] ciattach;
	private String[] civalues;
	private FormFile files;
	private String[] deleteEiid;
	/**开始时间*/
	protected String propentime;
	
	/**结束时间*/
	protected String prclosetime;
	
	/**应急资源id*/
	protected Integer erid;
	
	/**应急资源编码*/
	protected String ercode;
	
	/**应急资源名称*/
	protected String ername;
	
	/** 关联设备对象 */
	protected String[] relationEiid;
	
	/** 资产更新开始时间 */
	protected String eiupdtime_from;
	
	/** 资产更新截止时间 */
	protected String eiupdtime_to;
	
	/** 弹出页标识 */
	protected String openFlag;
	
	/**需要过滤掉的eiid(应急资源专用)*/
	protected String eiidNotIn;
	
	/** 对应资产模型码  */
	protected String esyscode;
	
	/** 单选标识  */
	protected String sign;

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEname() {
		return ename;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEidesc() {
		return eidesc;
	}

	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
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

	public String getEiinsdate() {
		return eiinsdate;
	}

	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public String getEiupdtime() {
		return eiupdtime;
	}

	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	public String getEistatus() {
		return eistatus;
	}

	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Integer getEiversion() {
		return eiversion;
	}

	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
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

	public Integer getEismallversion() {
		return eismallversion;
	}

	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	public Integer getEirootmark() {
		return eirootmark;
	}

	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	public String[] getCids() {
		return cids;
	}

	public void setCids(String[] cids) {
		this.cids = cids;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String[] getCiattach() {
		return ciattach;
	}

	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}

	public String[] getCivalues() {
		return civalues;
	}

	public void setCivalues(String[] civalues) {
		this.civalues = civalues;
	}

	public FormFile getFiles() {
		return files;
	}

	public void setFiles(FormFile files) {
		this.files = files;
	}

	public String[] getDeleteEiid() {
		return deleteEiid;
	}

	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	public String getPrclosetime() {
		return prclosetime;
	}

	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	public Integer getErid() {
		return erid;
	}

	public void setErid(Integer erid) {
		this.erid = erid;
	}

	public String getErcode() {
		return ercode;
	}

	public void setErcode(String ercode) {
		this.ercode = ercode;
	}

	public String getErname() {
		return ername;
	}

	public void setErname(String ername) {
		this.ername = ername;
	}

	public String[] getRelationEiid() {
		return relationEiid;
	}

	public void setRelationEiid(String[] relationEiid) {
		this.relationEiid = relationEiid;
	}

	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}

	public String getOpenFlag() {
		return openFlag;
	}

	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}

	public String getEiidNotIn() {
		return eiidNotIn;
	}

	public void setEiidNotIn(String eiidNotIn) {
		this.eiidNotIn = eiidNotIn;
	}

	public String getEsyscode() {
		return esyscode;
	}

	public void setEsyscode(String esyscode) {
		this.esyscode = esyscode;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
