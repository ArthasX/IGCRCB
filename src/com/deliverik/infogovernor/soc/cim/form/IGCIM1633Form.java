package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 资产项查询HELP画面用FORM
 * IGCOM0302Form ActionForm
 */
public class IGCIM1633Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	protected Integer eiid;
	/** 关系ID */
	protected Integer eirid;
	
	/** 关系ID（文字） */
	protected String eiridStr;

	/** 设备ID（父） */
	protected Integer pareiid;
	
	/** 设备label（父） */
	protected String pareilabel;

	/** 设备资产ID（父） */
	protected String pareid;

	/** 资产项ID（子） */
	protected Integer cldeiid;

	/** 资产ID（子） */
	protected String cldeid;

	/** 关系更新时间 */
	protected String eirupdtime;
	
	/** 关系状态 */
	protected String eirstatus;
	
	/** 关系说明 */
	protected String eirdesc;
	
	/** 关系 */
	protected String eirrelation;

	/** 编辑模式（登记/变更） */
	protected String mode = "0";

	/** 资产项模型编码（子） */
	protected String elabel;

	/** 资产项编码（子） */
	protected String eilabel;

	/** 资产项名称（子） */
	protected String einame;

	/** 设备名称(父) */
	protected String pareiname;
	
	/** 资产项关系代码 */
	protected String eirrelationcode;
	
	/** 资产项关系 */
	protected String tempeirrelation;
	
	protected String fingerPrint;
	
	/** 资产所属树根节点实体标识 */
	protected Integer eirootmark;

	/**
	 * 通过资产属性增加自动生成的关系信息
	 * @return 通过资产属性增加自动生成的关系信息
	 */
	protected String eirinfo;
	
	/** 资产关系编码（平台保留） */
	protected String eirsyscodeing;
	
	/** 正向资产大版本 */
	protected Integer parversion;

	/** 正向资产小版本 */
	protected Integer parsmallversion;

	/** 反向资产大版本 */
	protected Integer cldversion;

	/** 反向资产小版本 */
	protected Integer cldsmallversion;

	/** 逻辑删除标识 */
	protected String deleteflag;
	
	/** 关系类型(普通关系、依赖关系) */
	protected String relationType;
	
	/** 依赖类型(物理、逻辑) */
	protected String belongType;
	
	/** 层次码 */
	protected String esyscoding;
	
	protected String pidid;
	
	

	public String getPidid() {
		return pidid;
	}

	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	public Integer getEirid() {
		return eirid;
	}

	public void setEirid(Integer eirid) {
		this.eirid = eirid;
	}

	public String getEiridStr() {
		return eiridStr;
	}

	public void setEiridStr(String eiridStr) {
		this.eiridStr = eiridStr;
	}

	public Integer getPareiid() {
		return pareiid;
	}

	public void setPareiid(Integer pareiid) {
		this.pareiid = pareiid;
	}

	public String getPareilabel() {
		return pareilabel;
	}

	public void setPareilabel(String pareilabel) {
		this.pareilabel = pareilabel;
	}

	public String getPareid() {
		return pareid;
	}

	public void setPareid(String pareid) {
		this.pareid = pareid;
	}

	public Integer getCldeiid() {
		return cldeiid;
	}

	public void setCldeiid(Integer cldeiid) {
		this.cldeiid = cldeiid;
	}

	public String getCldeid() {
		return cldeid;
	}

	public void setCldeid(String cldeid) {
		this.cldeid = cldeid;
	}

	public String getEirupdtime() {
		return eirupdtime;
	}

	public void setEirupdtime(String eirupdtime) {
		this.eirupdtime = eirupdtime;
	}

	public String getEirstatus() {
		return eirstatus;
	}

	public void setEirstatus(String eirstatus) {
		this.eirstatus = eirstatus;
	}

	public String getEirdesc() {
		return eirdesc;
	}

	public void setEirdesc(String eirdesc) {
		this.eirdesc = eirdesc;
	}

	public String getEirrelation() {
		return eirrelation;
	}

	public void setEirrelation(String eirrelation) {
		this.eirrelation = eirrelation;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getElabel() {
		return elabel;
	}

	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	public String getEilabel() {
		return eilabel;
	}

	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getPareiname() {
		return pareiname;
	}

	public void setPareiname(String pareiname) {
		this.pareiname = pareiname;
	}

	public String getEirrelationcode() {
		return eirrelationcode;
	}

	public void setEirrelationcode(String eirrelationcode) {
		this.eirrelationcode = eirrelationcode;
	}

	public String getTempeirrelation() {
		return tempeirrelation;
	}

	public void setTempeirrelation(String tempeirrelation) {
		this.tempeirrelation = tempeirrelation;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public Integer getEirootmark() {
		return eirootmark;
	}

	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	public String getEirinfo() {
		return eirinfo;
	}

	public void setEirinfo(String eirinfo) {
		this.eirinfo = eirinfo;
	}

	public String getEirsyscodeing() {
		return eirsyscodeing;
	}

	public void setEirsyscodeing(String eirsyscodeing) {
		this.eirsyscodeing = eirsyscodeing;
	}

	public Integer getParversion() {
		return parversion;
	}

	public void setParversion(Integer parversion) {
		this.parversion = parversion;
	}

	public Integer getParsmallversion() {
		return parsmallversion;
	}

	public void setParsmallversion(Integer parsmallversion) {
		this.parsmallversion = parsmallversion;
	}

	public Integer getCldversion() {
		return cldversion;
	}

	public void setCldversion(Integer cldversion) {
		this.cldversion = cldversion;
	}

	public Integer getCldsmallversion() {
		return cldsmallversion;
	}

	public void setCldsmallversion(Integer cldsmallversion) {
		this.cldsmallversion = cldsmallversion;
	}

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public String getBelongType() {
		return belongType;
	}

	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	
	
	
	
	
	
}
